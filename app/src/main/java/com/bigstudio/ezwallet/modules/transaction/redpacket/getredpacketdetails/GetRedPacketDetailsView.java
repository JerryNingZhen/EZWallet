package com.bigstudio.ezwallet.modules.transaction.redpacket.getredpacketdetails;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.RedPacketDetailsBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface GetRedPacketDetailsView extends BaseView {
    void getRedPacketDetailsDataHttp(RedPacketDetailsBean.DataBean dataBean);

    void getDataHttpFail(String msg);
}
