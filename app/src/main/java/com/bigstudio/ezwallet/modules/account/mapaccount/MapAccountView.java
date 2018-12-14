package com.bigstudio.ezwallet.modules.account.mapaccount;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.GetAccountsBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface MapAccountView extends BaseView {

    void getBlackAccountDataHttp(GetAccountsBean getAccountsBean);

    void setMainAccountHttp();

    void getDataHttpFail(String msg);

    void postEosAccountDataHttp();
}
