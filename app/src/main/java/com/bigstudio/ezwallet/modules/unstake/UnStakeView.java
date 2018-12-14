package com.bigstudio.ezwallet.modules.unstake;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.AccountDetailsBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface UnStakeView extends BaseView {

    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);

    void getDataHttpFail(String msg);
}
