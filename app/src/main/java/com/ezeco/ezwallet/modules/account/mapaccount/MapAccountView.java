package com.ezeco.ezwallet.modules.account.mapaccount;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.GetAccountsBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface MapAccountView extends BaseView {

    void getBlackAccountDataHttp(GetAccountsBean getAccountsBean);

    void setMainAccountHttp();

    void getDataHttpFail(String msg);

    void postEosAccountDataHttp();
}
