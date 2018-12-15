package com.ezeco.ezwallet.modules.transaction.makecollections;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.CoinRateBean;
import com.ezeco.ezwallet.bean.TransferHistoryBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface MakeCollectionsView extends BaseView {
    void getCoinRateDataHttp(CoinRateBean.DataBean coinRateBean);

    void getTransferHistoryDataHttp(TransferHistoryBean.DataBeanX transferHistoryBean);


    void getDataHttpFail(String msg);
}
