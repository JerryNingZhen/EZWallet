package com.ezeco.ezwallet.modules.unstake;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.AccountDetailsBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface UnStakeView extends BaseView {

    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);

    void getDataHttpFail(String msg);
}
