package com.ezeco.ezwallet.modules.leftdrawer.transactionhistory;

import android.content.Context;

import com.google.gson.Gson;
import com.lzy.okgo.model.Response;
import com.ezeco.ezwallet.base.BasePresent;
import com.ezeco.ezwallet.base.BaseUrl;
import com.ezeco.ezwallet.bean.PostChainHistoryBean;
import com.ezeco.ezwallet.bean.TransferHistoryBean;
import com.ezeco.ezwallet.net.HttpUtils;
import com.ezeco.ezwallet.net.callbck.JsonCallback;

/**
 * Created by pocketEos on 2017/12/26.
 */

public class TransactionHistoryPresenter extends BasePresent<TransactionHistoryView> {
    private Context mContext;

    public TransactionHistoryPresenter(Context context) {
        this.mContext = context;
    }

    public void getTransferHistoryData(PostChainHistoryBean postChainHistoryBean) {
        HttpUtils.postRequest(BaseUrl.HTTP_get_transaction_history, mContext, new Gson().toJson(postChainHistoryBean), new JsonCallback<TransferHistoryBean>() {
            @Override
            public void onSuccess(Response<TransferHistoryBean> response) {
                if (response.body().getCode().equals("0")) {
                    view.getTransferHistoryDataHttp(response.body().getData());
                } else {
                    view.getDataHttpFail(response.body().getMsg());
                }
            }
        });
    }
}
