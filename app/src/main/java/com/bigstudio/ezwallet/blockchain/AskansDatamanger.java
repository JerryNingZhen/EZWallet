package com.bigstudio.ezwallet.blockchain;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.model.Response;
import com.bigstudio.ezwallet.base.BaseUrl;
import com.bigstudio.ezwallet.base.Constants;
import com.bigstudio.ezwallet.bean.ResponseBean;
import com.bigstudio.ezwallet.blockchain.api.EosChainInfo;
import com.bigstudio.ezwallet.blockchain.bean.GetRequiredKeys;
import com.bigstudio.ezwallet.blockchain.bean.JsonToBeanResultBean;
import com.bigstudio.ezwallet.blockchain.bean.JsonToBinRequest;
import com.bigstudio.ezwallet.blockchain.bean.PushSuccessBean;
import com.bigstudio.ezwallet.blockchain.bean.RequreKeyResult;
import com.bigstudio.ezwallet.blockchain.chain.Action;
import com.bigstudio.ezwallet.blockchain.chain.PackedTransaction;
import com.bigstudio.ezwallet.blockchain.chain.SignedTransaction;
import com.bigstudio.ezwallet.blockchain.cypto.ec.EosPrivateKey;
import com.bigstudio.ezwallet.blockchain.types.TypeChainId;
import com.bigstudio.ezwallet.blockchain.util.GsonEosTypeAdapterFactory;
import com.bigstudio.ezwallet.net.HttpUtils;
import com.bigstudio.ezwallet.net.callbck.JsonCallback;
import com.bigstudio.ezwallet.utils.JsonUtil;
import com.bigstudio.ezwallet.utils.PublicAndPrivateKeyUtils;
import com.bigstudio.ezwallet.utils.ShowDialog;
import com.bigstudio.ezwallet.utils.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pocketEos on 2018/5/11.
 * 币答测试管理
 */

public class AskansDatamanger {
    public  static String OCTCONTRACT =  Constants.OCTCONTRACT;//erctoken
    public  static String OCTASKANSCONTRACT = Constants.OCTASKANSCONTRACT;//erctoken
    public  static String ACTIONAPPROVE =  Constants.ACTIONAPPROVE;//授权可转走（押币）
    public  static String ACTIONASK =  Constants.ACTIONASK;//押币后提问
    public  static String ACTIONANSWER =  Constants.ACTIONANSWER;//押币后回答问题
    public  static String PERMISSONION =  Constants.PERMISSONION;

    Callback mCallback;
    Context mContext;
    EosChainInfo mChainInfoBean = new EosChainInfo();
    JsonToBeanResultBean mJsonToBeanResultBean = new JsonToBeanResultBean();
    String[] permissions;
    SignedTransaction txnBeforeSign;
    Gson mGson = new GsonBuilder()
            .registerTypeAdapterFactory(new GsonEosTypeAdapterFactory())
            .excludeFieldsWithoutExposeAnnotation().create();

    String contract, action, message, userpassword;

    public AskansDatamanger(Context context, String userpassword, Callback callback) {
        mContext = context;
        mCallback = callback;
        this.userpassword = userpassword;
    }

    public void pushAction(String contract, String action, String message, String permissionAccount) {
        this.message = message;
        this.contract = contract;
        this.action = action;
        permissions = new String[]{permissionAccount + "@" + PERMISSONION};
        getChainInfo();
    }

    public void getChainInfo() {
        HttpUtils.getRequets(BaseUrl.HTTP_get_chain_info, this, new HashMap<String, String>(), new JsonCallback<ResponseBean>() {
            @Override
            public void onSuccess(Response<ResponseBean> response) {
                if (response.body().code == 0) {
                    mChainInfoBean = (EosChainInfo) JsonUtil.parseStringToBean(mGson.toJson(response.body().data), EosChainInfo.class);
                    getabi_json_to_bin();
                } else {
                    if (ShowDialog.dialog != null) {
                        ShowDialog.dissmiss();
                    }
                    ToastUtils.showLongToast(response.body().message);
                }
            }
        });
    }

    public void getabi_json_to_bin() {
        JsonToBinRequest jsonToBinRequest = new JsonToBinRequest(contract, action, message.replaceAll("\\r|\\n", ""));
        HttpUtils.postRequest(BaseUrl.HTTP_get_abi_json_to_bin, this, mGson.toJson(jsonToBinRequest), new JsonCallback<ResponseBean>() {
            @Override
            public void onSuccess(Response<ResponseBean> response) {
                if (response.body().code == 0) {
                    mJsonToBeanResultBean = (JsonToBeanResultBean) JsonUtil.parseStringToBean(mGson.toJson(response.body().data), JsonToBeanResultBean.class);
                    txnBeforeSign = createTransaction(contract, action, mJsonToBeanResultBean.getBinargs(), permissions, mChainInfoBean);
                    //扫描钱包列出所有可用账号的公钥
                    List<String> pubKey = PublicAndPrivateKeyUtils.getActivePublicKey();

                    getRequreKey(new GetRequiredKeys(txnBeforeSign, pubKey));
                } else {
                    if (ShowDialog.dialog != null) {
                        ShowDialog.dissmiss();
                    }
                    ToastUtils.showLongToast(response.body().message);
                }
            }
        });
    }

    private SignedTransaction createTransaction(String contract, String actionName, String dataAsHex,
                                                String[] permissions, EosChainInfo chainInfo) {

        Action action = new Action(contract, actionName);
        action.setAuthorization(permissions);
        action.setData(dataAsHex);


        SignedTransaction txn = new SignedTransaction();
        txn.addAction(action);
        txn.putSignatures(new ArrayList<String>());


        if (null != chainInfo) {
            txn.setReferenceBlock(chainInfo.getHeadBlockId());
            txn.setExpiration(chainInfo.getTimeAfterHeadBlockTime(30000));
        }
        return txn;
    }

    public void getRequreKey(GetRequiredKeys getRequiredKeys) {
        HttpUtils.postRequest(BaseUrl.HTTP_get_required_keys, this, mGson.toJson(getRequiredKeys), new JsonCallback<ResponseBean>() {
            @Override
            public void onSuccess(Response<ResponseBean> response) {
                if (response.body().code == 0) {
                    RequreKeyResult requreKeyResult = (RequreKeyResult) JsonUtil.parseStringToBean(mGson.toJson(response.body().data), RequreKeyResult.class);
                    EosPrivateKey eosPrivateKey = new EosPrivateKey(PublicAndPrivateKeyUtils.getPrivateKey(requreKeyResult.getRequired_keys().get(0), userpassword));
                    txnBeforeSign.sign(eosPrivateKey, new TypeChainId(mChainInfoBean.getChain_id()));
                    pushTransactionRetJson(new PackedTransaction(txnBeforeSign));
                } else {
                    if (ShowDialog.dialog != null) {
                        ShowDialog.dissmiss();
                    }
                    ToastUtils.showLongToast(response.body().message);
                }
            }
        });
    }



    public void pushTransactionRetJson(PackedTransaction body) {
        HttpUtils.postRequest(BaseUrl.HTTP_push_transaction, this, mGson.toJson(body), new JsonCallback<ResponseBean>() {
            @Override
            public void onSuccess(final Response<ResponseBean> response) {
                if (ShowDialog.dialog != null) {
                    ShowDialog.dissmiss();
                }
                if (response.body().code == 0) {
                    PushSuccessBean.DataBeanX dataBeanX = (PushSuccessBean.DataBeanX) JsonUtil.parseStringToBean(mGson.toJson(response.body().data), PushSuccessBean.DataBeanX.class);
                    mCallback.isApprove(action);
                } else {
                    ToastUtils.showLongToast(response.body().message);
                }
            }
        });
    }

    public interface Callback {
        void isApprove(String action);
    }
}
