package com.bigstudio.ezwallet.modules.account.createaccount;

import com.bigstudio.ezwallet.base.BaseView;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface CreateAccountView extends BaseView {


    void postEosAccountDataHttp();
    void getDataHttpFail(String msg);
    void setMainAccountHttp();
}
