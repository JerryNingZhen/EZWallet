package com.ezeco.ezwallet.modules.nodevote.surevote;

import android.content.Context;

import com.google.gson.Gson;
import com.lzy.okgo.model.Response;
import com.ezeco.ezwallet.app.MyApplication;
import com.ezeco.ezwallet.base.BasePresent;
import com.ezeco.ezwallet.base.BaseUrl;
import com.ezeco.ezwallet.bean.RequestTableRowsBean;
import com.ezeco.ezwallet.bean.ResponseBean;
import com.ezeco.ezwallet.bean.ResultTableRowBean;
import com.ezeco.ezwallet.bean.ResultVoteWeightBean;
import com.ezeco.ezwallet.net.HttpUtils;
import com.ezeco.ezwallet.net.callbck.JsonCallback;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by pocketEos on 2017/12/26.
 */

public class SureNodeVotePresenter extends BasePresent<SureNodeVoteView> {
    private Context mContext;

    public SureNodeVotePresenter(Context context) {
        this.mContext = context;
    }

    public void getNowVoteWeightData() {
        HttpUtils.getRequets(BaseUrl.getHTTP_GetNowVoteWeight, mContext, new HashMap<>(), new JsonCallback<ResultVoteWeightBean>() {
            @Override
            public void onSuccess(Response<ResultVoteWeightBean> response) {
                view.getNowVoteWeightDataHttp(response.body());
            }
        });
    }

    public void getAccountVoteData(String account) {
        RequestTableRowsBean requestTableRowsBean = new RequestTableRowsBean();
        requestTableRowsBean.setAccountNameStr(account);
        HttpUtils.postRequest(BaseUrl.getHTTP_GetMyVoteInfo, mContext, new Gson().toJson(requestTableRowsBean), new JsonCallback<ResultTableRowBean>() {
            @Override
            public void onSuccess(Response<ResultTableRowBean> response) {
                view.getAccountVoteDataHttp(response.body());
            }
        });
    }

    public void getcomplete_taskData() {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", MyApplication.getInstance().getUserBean().getWallet_uid());
        hashMap.put("id", "c0b92ad2a778418c9ec860f3f7e79c21");
        HttpUtils.postRequest(BaseUrl.getHTTP_complete_task, mContext, new JSONObject(hashMap).toString(), new JsonCallback<ResponseBean<String>>() {
            @Override
            public void onSuccess(Response<ResponseBean<String>> response) {
                if (response.body() != null) {
                    view.postVoteTask(response.body());
                }
            }
        });
    }
}
