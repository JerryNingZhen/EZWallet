package com.ezeco.ezwallet.modules.transaction.transferaccounts.switchfriend;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.ezeco.ezwallet.app.MyApplication;
import com.ezeco.ezwallet.base.BasePresent;
import com.ezeco.ezwallet.base.BaseUrl;
import com.ezeco.ezwallet.bean.FriendsListInfoBean;
import com.ezeco.ezwallet.net.HttpUtils;
import com.ezeco.ezwallet.bean.ResponseBean;
import com.ezeco.ezwallet.net.callbck.JsonCallback;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 */

public class SwitchFriendPresenter extends BasePresent<SwitchFriendView> {
    private Context mContext;

    public SwitchFriendPresenter(Context context) {
        this.mContext = context;
    }
    public void getData() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("uid", MyApplication.getInstance().getUserBean().getWallet_uid());
        HttpUtils.postRequest(BaseUrl.HTTP_Getfollow_list, mContext, hashMap, new JsonCallback<ResponseBean<List<FriendsListInfoBean>>>() {
            @Override
            public void onSuccess(Response<ResponseBean<List<FriendsListInfoBean>>> response) {
                if (response.body().code == 0) {
                    view.getDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }
}
