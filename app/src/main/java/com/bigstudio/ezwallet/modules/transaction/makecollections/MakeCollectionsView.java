package com.oraclechain.ezwallet.modules.transaction.makecollections;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.CoinRateBean;
import com.oraclechain.ezwallet.bean.TransferHistoryBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface MakeCollectionsView extends BaseView {
    void getCoinRateDataHttp(CoinRateBean.DataBean coinRateBean);

    void getTransferHistoryDataHttp(TransferHistoryBean.DataBeanX transferHistoryBean);


    void getDataHttpFail(String msg);
}
