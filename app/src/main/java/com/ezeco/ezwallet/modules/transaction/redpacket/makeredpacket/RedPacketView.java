package com.bigstudio.ezwallet.modules.transaction.redpacket.makeredpacket;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.CoinRateBean;
import com.bigstudio.ezwallet.bean.RedPacketHistoryBean;
import com.bigstudio.ezwallet.bean.SendRedPacketBean;

import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface RedPacketView extends BaseView {
    void getCoinRateDataHttp(CoinRateBean.DataBean coinRateBean);

    void getRedPacketHistoryDataHttp(List<RedPacketHistoryBean.DataBean> dataBeanList);

    void sendRedPacketDataHttp(SendRedPacketBean.DataBean sendRedPacketBean);


    void getDataHttpFail(String msg);
}
