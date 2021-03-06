package com.ezeco.ezwallet.modules.blackbox.blackhome;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.AccountWithCoinBean;

import java.util.List;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface BlackBoxHomeView extends BaseView {

    void getAccountDetailsDataHttp(List<AccountWithCoinBean> mAccountWithCoinBeen);

    void getDataHttpFail(String msg);
}
