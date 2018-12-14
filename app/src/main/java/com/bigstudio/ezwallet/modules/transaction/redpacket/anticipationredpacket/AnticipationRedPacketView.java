package com.oraclechain.ezwallet.modules.transaction.redpacket.anticipationredpacket;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.AuthRedPacketBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface AnticipationRedPacketView extends BaseView {
    void getAuthRedPacketDataHttp(AuthRedPacketBean.DataBean dataBean);

    void getDataHttpFail(String msg);
}
