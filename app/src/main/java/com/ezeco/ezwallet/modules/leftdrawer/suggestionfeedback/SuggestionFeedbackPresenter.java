package com.ezeco.ezwallet.modules.leftdrawer.suggestionfeedback;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.ezeco.ezwallet.app.MyApplication;
import com.ezeco.ezwallet.base.BasePresent;
import com.ezeco.ezwallet.base.BaseUrl;
import com.ezeco.ezwallet.bean.SuggestionBean;
import com.ezeco.ezwallet.net.HttpUtils;
import com.ezeco.ezwallet.bean.ResponseBean;
import com.ezeco.ezwallet.net.callbck.JsonCallback;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 */

public class SuggestionFeedbackPresenter extends BasePresent<SuggestionFeedbackView> {
    private Context mContext;

    public SuggestionFeedbackPresenter(Context context) {
        this.mContext = context;
    }

    public void postSuggestionDetails(String content) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("uid", MyApplication.getInstance().getUserBean().getWallet_uid());
        hashMap.put("content", content);
        HttpUtils.postRequest(BaseUrl.HTTP_post_suggestion, mContext, hashMap, new JsonCallback<ResponseBean<String>>() {
            @Override
            public void onSuccess(Response<ResponseBean<String>> response) {
                if (response.body().code == 0) {
                    view.postSuggestionHttp();
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }

    public void getSuggestionList(int offset) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("offset", offset + "");
        hashMap.put("size", "10");
        hashMap.put("uid", MyApplication.getInstance().getUserBean().getWallet_uid());
        HttpUtils.postRequest(BaseUrl.HTTP_get_suggestion_list, mContext, hashMap, new JsonCallback<ResponseBean<List<SuggestionBean.DataBean>>>() {
            @Override
            public void onSuccess(Response<ResponseBean<List<SuggestionBean.DataBean>>> response) {
                if (response.body().code == 0) {
                    view.getSuggestionListHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }
}
