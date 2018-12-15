package com.ezeco.ezwallet.modules.nodevote.gonodevote;

import android.content.Context;

import com.google.gson.Gson;
import com.lzy.okgo.model.Response;
import com.ezeco.ezwallet.base.BasePresent;
import com.ezeco.ezwallet.base.BaseUrl;
import com.ezeco.ezwallet.bean.RequestNodeListBean;
import com.ezeco.ezwallet.bean.ResultNodeListBean;
import com.ezeco.ezwallet.net.HttpUtils;
import com.ezeco.ezwallet.net.callbck.JsonCallback;

/**
 * Created by pocketEos on 2017/12/26.
 */

public class GoNodeVotePresenter extends BasePresent<GoNodeVoteView> {
    private Context mContext;

    public GoNodeVotePresenter(Context context) {
        this.mContext = context;
    }

    public void getNodeListData(int page) {
        RequestNodeListBean requestNodeListBean = new RequestNodeListBean();
        requestNodeListBean.setPageNum(page+"");//分页开始的节点名称
        requestNodeListBean.setPageSize("10");
        HttpUtils.postRequest(BaseUrl.getHTTP_GetBpJson, mContext, new Gson().toJson(requestNodeListBean), new JsonCallback<ResultNodeListBean>() {
            @Override
            public void onSuccess(Response<ResultNodeListBean> response) {
                view.getNodeListDataHttp(response.body());
            }
        });
    }
}
