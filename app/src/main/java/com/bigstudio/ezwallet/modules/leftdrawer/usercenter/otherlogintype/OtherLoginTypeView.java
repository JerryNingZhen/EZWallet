package com.oraclechain.ezwallet.modules.leftdrawer.usercenter.otherlogintype;

import com.oraclechain.ezwallet.base.BaseView;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface OtherLoginTypeView extends BaseView {

    void unBindOtherLoginDataHttp();

    void bindOtherLoginDataHttp();

    void getDataHttpFail(String msg);
}
