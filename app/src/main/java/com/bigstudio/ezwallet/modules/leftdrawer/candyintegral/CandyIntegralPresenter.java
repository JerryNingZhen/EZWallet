package com.bigstudio.ezwallet.modules.leftdrawer.candyintegral;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.bigstudio.ezwallet.app.MyApplication;
import com.bigstudio.ezwallet.base.BasePresent;
import com.bigstudio.ezwallet.base.BaseUrl;
import com.bigstudio.ezwallet.bean.CandyScoreBean;
import com.bigstudio.ezwallet.bean.CandyUserTaskBean;
import com.bigstudio.ezwallet.bean.HotEquitiesBean;
import com.bigstudio.ezwallet.bean.ResponseBean;
import com.bigstudio.ezwallet.net.HttpUtils;
import com.bigstudio.ezwallet.net.callbck.JsonCallback;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 */

public class CandyIntegralPresenter extends BasePresent<CandyIntegralView> {
    private Context mContext;

    public CandyIntegralPresenter(Context context) {
        this.mContext = context;
    }

    public void getCandyData() {
        String url = BaseUrl.getHTTP_get_candy_score+"/"+MyApplication.getInstance().getUserBean().getWallet_uid();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        HttpUtils.getRequets(url, mContext, hashMap, new JsonCallback<ResponseBean<CandyScoreBean.DataBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<CandyScoreBean.DataBean>> response) {
                if (response.body().code == 0) {
                    view.getCandyScoreDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });


        HttpUtils.getRequets(BaseUrl.getHTTP_get_all_exchange, mContext, hashMap, new JsonCallback<ResponseBean<List<HotEquitiesBean.DataBean>>>() {
            @Override
            public void onSuccess(Response<ResponseBean<List<HotEquitiesBean.DataBean>>> response) {
                if (response.body().code == 0) {
                    view.getHotEquitiesDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });

        String taskUrl = BaseUrl.getHTTP_get_user_task+"/"+MyApplication.getInstance().getUserBean().getWallet_uid();
        HttpUtils.getRequets(taskUrl, mContext, hashMap, new JsonCallback<ResponseBean<List<CandyUserTaskBean.DataBean>>>() {
            @Override
            public void onSuccess(Response<ResponseBean<List<CandyUserTaskBean.DataBean>>> response) {
                if (response.body().code == 0) {
                    view.getCandyTaskDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }

}
