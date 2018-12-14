package com.oraclechain.ezwallet.modules.unstake;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.AccountDetailsBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface UnStakeView extends BaseView {

    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);

    void getDataHttpFail(String msg);
}
