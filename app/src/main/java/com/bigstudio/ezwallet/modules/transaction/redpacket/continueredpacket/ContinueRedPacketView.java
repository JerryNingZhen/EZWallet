package com.oraclechain.ezwallet.modules.transaction.redpacket.continueredpacket;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.CoinRateBean;
import com.oraclechain.ezwallet.bean.RedPacketDetailsBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface ContinueRedPacketView extends BaseView {
    void getCoinRateDataHttp(CoinRateBean.DataBean coinRateBean);

    void getRedPacketDetailsDataHttp(RedPacketDetailsBean.DataBean dataBean);

    void getDataHttpFail(String msg);
}
