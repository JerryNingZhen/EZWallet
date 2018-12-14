package com.oraclechain.ezwallet.modules.transaction.redpacket.makeredpacket;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.CoinRateBean;
import com.oraclechain.ezwallet.bean.RedPacketHistoryBean;
import com.oraclechain.ezwallet.bean.SendRedPacketBean;

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
