package com.ezeco.ezwallet.modules.transaction.redpacket.continueredpacket;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.CoinRateBean;
import com.ezeco.ezwallet.bean.RedPacketDetailsBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface ContinueRedPacketView extends BaseView {
    void getCoinRateDataHttp(CoinRateBean.DataBean coinRateBean);

    void getRedPacketDetailsDataHttp(RedPacketDetailsBean.DataBean dataBean);

    void getDataHttpFail(String msg);
}
