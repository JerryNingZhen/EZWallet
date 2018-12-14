package com.oraclechain.ezwallet.modules.dapp.paidanswer.paidanswerhome.fragment;

import android.content.Context;

import com.google.gson.Gson;
import com.lzy.okgo.model.Response;
import com.oraclechain.ezwallet.base.BasePresent;
import com.oraclechain.ezwallet.base.BaseUrl;
import com.oraclechain.ezwallet.bean.GetAnswerListBean;
import com.oraclechain.ezwallet.bean.PaidAnswerBean;
import com.oraclechain.ezwallet.net.HttpUtils;
import com.oraclechain.ezwallet.net.callbck.JsonCallback;

/**
 * Created by pocketEos on 2017/12/26.
 */

public class PaidAnswerPresenter extends BasePresent<PaidAnswerView> {
    private Context mContext;

    public PaidAnswerPresenter(Context context) {
        this.mContext = context;
    }
    public void getData(int page , String releasedLable ,String askid ) {
        HttpUtils.postRequest(BaseUrl.HTTP_GetAsks, mContext, new Gson().toJson(new GetAnswerListBean(askid,new GetAnswerListBean.PageBean(page,10),releasedLable)), new JsonCallback<PaidAnswerBean>() {
            @Override
            public void onSuccess(Response<PaidAnswerBean> response) {
                if (response.body().getCode().equals("0")) {
                    view.getQuestionListDataHttp(response.body().getData());
                } else {
                    view.getDataHttpFail(response.body().getMsg());
                }
            }
        });
    }

}