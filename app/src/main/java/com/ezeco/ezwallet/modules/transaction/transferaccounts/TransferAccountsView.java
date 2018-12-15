package com.ezeco.ezwallet.modules.transaction.transferaccounts;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.AccountDetailsBean;
import com.ezeco.ezwallet.bean.CoinRateBean;
import com.ezeco.ezwallet.bean.TransferHistoryBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface TransferAccountsView extends BaseView {
    void getCoinRateDataHttp(CoinRateBean.DataBean coinRateBean);

    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);


    void getTransferHistoryDataHttp(TransferHistoryBean.DataBeanX transferHistoryBean);

    void getDataHttpFail(String msg);
}
