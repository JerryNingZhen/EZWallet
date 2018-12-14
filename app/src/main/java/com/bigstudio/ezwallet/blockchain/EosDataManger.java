package com.bigstudio.ezwallet.blockchain;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.model.Response;
import com.bigstudio.ezwallet.R;
import com.bigstudio.ezwallet.app.ActivityUtils;
import com.bigstudio.ezwallet.base.BaseUrl;
import com.bigstudio.ezwallet.base.Constants;
import com.bigstudio.ezwallet.bean.ResponseBean;
import com.bigstudio.ezwallet.bean.SendRedPacketBean;
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
import com.bigstudio.ezwallet.modules.transaction.redpacket.anticipationredpacket.AnticipationRedPacketActivity;
import com.bigstudio.ezwallet.net.HttpUtils;
import com.bigstudio.ezwallet.net.callbck.JsonCallback;
import com.bigstudio.ezwallet.utils.BigDecimalUtil;
import com.bigstudio.ezwallet.utils.JsonUtil;
import com.bigstudio.ezwallet.utils.PublicAndPrivateKeyUtils;
import com.bigstudio.ezwallet.utils.ShowDialog;
import com.bigstudio.ezwallet.utils.ToastUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pocketEos on 2018/5/2.
 * eosX适配
 */

public class EosDataManger {
    static String EOSCONTRACT = Constants.EOSCONTRACT;
    static String OCTCONTRACT =  Constants.OCTCONTRACT;//erctoken
    static String ACTIONTRANSFER = Constants.ACTIONTRANSFER;
    static String PERMISSONION = Constants.PERMISSONION;

    Context mContext;
    EosChainInfo mChainInfoBean = new EosChainInfo();
    JsonToBeanResultBean mJsonToBeanResultBean = new JsonToBeanResultBean();
    String[] permissions;
    SignedTransaction txnBeforeSign;
    Gson mGson = new GsonBuilder()
            .registerTypeAdapterFactory(new GsonEosTypeAdapterFactory())
            .excludeFieldsWithoutExposeAnnotation().create();

    String contract, action, message, userpassword;
    int type = 1; //0即为红包 ， 1为转账
    SendRedPacketBean.DataBean redpacketInfo = new SendRedPacketBean.DataBean(); // 红包信息
    String redpacketNumber = null;
    BigDecimal coinRate;//资产汇率

    public EosDataManger(Context context, String password) {
        mContext = context;
        this.userpassword = password;
    }




    public void pushAction(String message, String permissionAccount) {
        this.message = message;
        if (message.contains("EOS")) {
            this.contract = EOSCONTRACT;
        } else {
            this.contract = OCTCONTRACT;
        }
        this.action = ACTIONTRANSFER;
        this.type = 1;
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
                    List<String> pubKey =  PublicAndPrivateKeyUtils.getActivePublicKey();

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

                if (response.body().code == 0) {
                    PushSuccessBean.DataBeanX dataBeanX = (PushSuccessBean.DataBeanX) JsonUtil.parseStringToBean(mGson.toJson(response.body().data), PushSuccessBean.DataBeanX.class);
                    final Bundle bundle = new Bundle();
                    if (type == 1) {
                        if (ShowDialog.dialog != null) {
                            ShowDialog.dissmiss();
                        }
                        ToastUtils.showLongToast(R.string.transfersuccess);
                        bundle.putString("account", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getFrom());
                        bundle.putString("coin_type", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getQuantity().split(" ")[1]);
                        bundle.putString("coin_number", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getQuantity().split(" ")[0]);
                        bundle.putString("coin_cny", BigDecimalUtil.multiply(BigDecimal.valueOf(Double.parseDouble(dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getQuantity().split(" ")[0])), coinRate, 4) + "");
                        ActivityUtils.goBackWithResult((Activity) mContext, 300, bundle);
                    } else {
                        if (redpacketInfo != null) {
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    if (ShowDialog.dialog != null) {
                                        ShowDialog.dissmiss();
                                    }
                                    bundle.putString("account", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getFrom());
                                    bundle.putString("redpacketNumber", redpacketNumber);
                                    bundle.putString("amount", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getQuantity().split(" ")[0]);
                                    bundle.putString("transferCode", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getQuantity().split(" ")[1]);
                                    bundle.putParcelable("info", redpacketInfo);
                                    bundle.putString("memo", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getMemo());
                                    bundle.putString("txtid", dataBeanX.getTransaction_id());
                                    ActivityUtils.next((Activity) mContext, AnticipationRedPacketActivity.class, bundle);
                                }
                            }, 1500);
                        }
                    }
                } else {
                    ToastUtils.showLongToast(response.body().message);
                }
            }
        });
    }

    public void sendRedPacket(String message, String permissionAccount) {
        this.message = message;
        if (message.contains("EOS")) {
            this.contract = EOSCONTRACT;
        } else {
            this.contract = OCTCONTRACT;
        }
        this.action = ACTIONTRANSFER;
        this.type = 0;
        permissions = new String[]{permissionAccount + "@" + PERMISSONION};
        getChainInfo();
    }

    public EosDataManger setRedpacketInfo(SendRedPacketBean.DataBean dataBean, String number) {
        this.redpacketInfo = dataBean;
        this.redpacketNumber = number;
        return this;
    }

    public EosDataManger setCoinRate(BigDecimal coinRate) {
        this.coinRate = coinRate;
        return this;
    }
}
