package com.ezeco.ezwallet.modules.coindetails;

import android.content.Context;

import com.google.gson.Gson;
import com.lzy.okgo.model.Response;
import com.ezeco.ezwallet.base.BasePresent;
import com.ezeco.ezwallet.base.BaseUrl;
import com.ezeco.ezwallet.bean.PostChainHistoryBean;
import com.ezeco.ezwallet.bean.ResponseBean;
import com.ezeco.ezwallet.bean.SparkLinesBean;
import com.ezeco.ezwallet.bean.TransferHistoryBean;
import com.ezeco.ezwallet.net.HttpUtils;
import com.ezeco.ezwallet.net.callbck.JsonCallback;

import java.util.HashMap;

/**
 * Created by pocketEos on 2017/12/26.
 */

public class CoinDetailsPresenter extends BasePresent<CoinDetailsView> {
    private Context mContext;

    public CoinDetailsPresenter(Context context) {
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

    public void getSparklinesData() {
        HttpUtils.getRequets(BaseUrl.HTTP_get_sparklines, mContext, new HashMap<String, String>(), new JsonCallback<ResponseBean<SparkLinesBean.DataBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<SparkLinesBean.DataBean>> response) {
                if (response.body().code == 0) {
                    view.getSparklinesData(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }
}
