package com.oraclechain.ezwallet.modules.friendslist.pelist;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.oraclechain.ezwallet.base.BasePresent;
import com.oraclechain.ezwallet.base.BaseUrl;
import com.oraclechain.ezwallet.bean.PelistBean;
import com.oraclechain.ezwallet.net.HttpUtils;
import com.oraclechain.ezwallet.bean.ResponseBean;
import com.oraclechain.ezwallet.net.callbck.JsonCallback;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 */

public class PelistPresenter extends BasePresent<PelistView> {
    private Context mContext;

    public PelistPresenter(Context context) {
        this.mContext = context;
    }


    public void getData(String type, int offset) {
        String url = null;
        if (type.equals("0")) {
            url = BaseUrl.HTTP_pelist;
        } else {
            url = BaseUrl.HTTP_commpanylist;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("offset", offset + "");
        hashMap.put("size", "10");
        HttpUtils.postRequest(url, mContext, hashMap, new JsonCallback<ResponseBean<List<PelistBean.DataBean>>>() {
            @Override
            public void onSuccess(Response<ResponseBean<List<PelistBean.DataBean>>> response) {
                if (response.body().code == 0) {
                    view.getListDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }

}
