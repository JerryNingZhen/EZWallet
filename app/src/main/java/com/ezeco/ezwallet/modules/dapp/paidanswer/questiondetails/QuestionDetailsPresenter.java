package com.ezeco.ezwallet.modules.dapp.paidanswer.questiondetails;

import android.content.Context;

import com.google.gson.Gson;
import com.lzy.okgo.model.Response;
import com.ezeco.ezwallet.base.BasePresent;
import com.ezeco.ezwallet.base.BaseUrl;
import com.ezeco.ezwallet.bean.ChainInfoBean;
import com.ezeco.ezwallet.bean.GetChainJsonBean;
import com.ezeco.ezwallet.bean.GetRequiredKeysBean;
import com.ezeco.ezwallet.bean.PostChainAnswerJsonBean;
import com.ezeco.ezwallet.bean.PostChainPublicKeyBean;
import com.ezeco.ezwallet.bean.TransferSuccessBean;
import com.ezeco.ezwallet.net.HttpUtils;
import com.ezeco.ezwallet.bean.ResponseBean;
import com.ezeco.ezwallet.net.callbck.JsonCallback;

import java.util.HashMap;

/**
 * Created by pocketEos on 2017/12/26.
 */

public class QuestionDetailsPresenter extends BasePresent<QuestionDetailsView> {
    private Context mContext;

    public QuestionDetailsPresenter(Context context) {
        this.mContext = context;
    }

    public void getChainInfo() {
        HttpUtils.getRequets(BaseUrl.HTTP_get_chain_info, mContext, new HashMap<String, String>(), new JsonCallback<ResponseBean<ChainInfoBean.DataBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<ChainInfoBean.DataBean>> response) {
                if (response.body().code == 0) {
                    view.getChainInfoHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }

    public void getJson(PostChainAnswerJsonBean postChainAnswerJsonBean) {
        HttpUtils.postRequest(BaseUrl.HTTP_get_abi_json_to_bin, mContext, new Gson().toJson(postChainAnswerJsonBean), new JsonCallback<ResponseBean<GetChainJsonBean.DataBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<GetChainJsonBean.DataBean>> response) {
                if (response.body().code == 0) {
                    view.getChainJsonHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }

    public void get_required_keys(PostChainPublicKeyBean postChainPublicKeyBean) {
        HttpUtils.postRequest(BaseUrl.HTTP_get_required_keys, mContext, new Gson().toJson(postChainPublicKeyBean), new JsonCallback<ResponseBean<GetRequiredKeysBean.DataBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<GetRequiredKeysBean.DataBean>> response) {
                if (response.body().code == 0) {
                    view.getRequiredKeysHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }

    public void push_transaction(PostChainPublicKeyBean.TransactionBean transactionBean) {
        HttpUtils.postRequest(BaseUrl.HTTP_push_transaction, mContext, new Gson().toJson(transactionBean), new JsonCallback<ResponseBean<TransferSuccessBean.DataBeanX>>() {
            @Override
            public void onSuccess(Response<ResponseBean<TransferSuccessBean.DataBeanX>> response) {
                if (response.body().code == 0) {
                    view.pushtransactionHttp();
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }
}
