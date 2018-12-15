package com.ezeco.ezwallet.modules.transaction.redpacket.makeredpacket;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.CoinRateBean;
import com.ezeco.ezwallet.bean.RedPacketHistoryBean;
import com.ezeco.ezwallet.bean.SendRedPacketBean;

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
