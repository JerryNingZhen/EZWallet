package com.bigstudio.ezwallet.modules.transaction.redpacket.getredpacketdetails;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.lzy.okgo.utils.OkLogger;
import com.bigstudio.ezwallet.base.BasePresent;
import com.bigstudio.ezwallet.base.BaseUrl;
import com.bigstudio.ezwallet.bean.RedPacketDetailsBean;
import com.bigstudio.ezwallet.bean.ResponseBean;
import com.bigstudio.ezwallet.net.HttpUtils;
import com.bigstudio.ezwallet.net.callbck.JsonCallback;

import java.util.HashMap;

/**
 * Created by pocketEos on 2017/12/26.
 */

public class GetRedPacketDetailsPresenter extends BasePresent<GetRedPacketDetailsView> {
    private Context mContext;

    public GetRedPacketDetailsPresenter(Context context) {
        this.mContext = context;
    }


    public void getRedPacketDetailsData(String redpacket_id) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("id", redpacket_id);
        HttpUtils.postRequest(BaseUrl.getHTTP_get_red_packet_details_history, mContext, hashMap, new JsonCallback<ResponseBean<RedPacketDetailsBean.DataBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<RedPacketDetailsBean.DataBean>> response) {

                if (response.body().code == 0) {
                    view.getRedPacketDetailsDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }
}
