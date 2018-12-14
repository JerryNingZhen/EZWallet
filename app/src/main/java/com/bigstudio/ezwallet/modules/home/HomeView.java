package com.bigstudio.ezwallet.modules.home;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.AccountWithCoinBean;

import java.util.List;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface HomeView extends BaseView {

    void getAccountDetailsDataHttp(List<AccountWithCoinBean> mAccountWithCoinBeen);

    void getDataHttpFail(String msg);
}
