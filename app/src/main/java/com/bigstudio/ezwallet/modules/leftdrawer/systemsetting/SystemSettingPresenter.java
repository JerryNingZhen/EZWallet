package com.bigstudio.ezwallet.modules.leftdrawer.systemsetting;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.bigstudio.ezwallet.base.BasePresent;
import com.bigstudio.ezwallet.base.BaseUrl;
import com.bigstudio.ezwallet.bean.SystemInfoBean;
import com.bigstudio.ezwallet.net.HttpUtils;
import com.bigstudio.ezwallet.bean.ResponseBean;
import com.bigstudio.ezwallet.net.callbck.JsonCallback;

import java.util.HashMap;

/**
 * Created by pocketEos on 2018/1/18.
 */

public class SystemSettingPresenter extends BasePresent<SystemSettingView> {
    private Context mContext;

    public SystemSettingPresenter(Context context) {
        this.mContext = context;
    }

    public void getSystemInfo(final String id) {//1：法律条款和隐私政策，2：关于Pocket EOS的内容
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("id", id);
        HttpUtils.postRequest(BaseUrl.HTTP_get_system_info, mContext, hashMap, new JsonCallback<ResponseBean<SystemInfoBean.DataBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<SystemInfoBean.DataBean>> response) {
                if (response.body().code == 0) {
                    view.getSystemInfoHttp(response.body().data, id);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }

}

