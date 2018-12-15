package com.bigstudio.ezwallet.modules.transaction.redpacket.anticipationredpacket;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.AuthRedPacketBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface AnticipationRedPacketView extends BaseView {
    void getAuthRedPacketDataHttp(AuthRedPacketBean.DataBean dataBean);

    void getDataHttpFail(String msg);
}
