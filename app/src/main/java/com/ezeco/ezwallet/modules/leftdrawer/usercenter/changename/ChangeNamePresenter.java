package com.bigstudio.ezwallet.modules.leftdrawer.usercenter.changename;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.bigstudio.ezwallet.app.MyApplication;
import com.bigstudio.ezwallet.base.BasePresent;
import com.bigstudio.ezwallet.base.BaseUrl;
import com.bigstudio.ezwallet.net.HttpUtils;
import com.bigstudio.ezwallet.bean.ResponseBean;
import com.bigstudio.ezwallet.net.callbck.JsonCallback;

import java.util.HashMap;

/**
 * Created by pocketEos on 2018/1/18.
 */

public class ChangeNamePresenter extends BasePresent<ChangeNameView> {

    private Context mContext;

    public ChangeNamePresenter(Context context) {
        this.mContext = context;
    }
    public void HTTP_updateNameData(String userName) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("uid",  MyApplication.getInstance().getUserBean().getWallet_uid());
        hashMap.put("userName", userName);
        HttpUtils.postRequest(BaseUrl.HTTP_updateName, mContext, hashMap, new JsonCallback<ResponseBean<String>>() {
            @Override
            public void onSuccess(Response<ResponseBean<String>> response) {
                if (response.body().code == 0) {
                    view.updateNameDataHttp();
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }

}

