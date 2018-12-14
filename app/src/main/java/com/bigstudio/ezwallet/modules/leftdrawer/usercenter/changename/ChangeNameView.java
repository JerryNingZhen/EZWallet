package com.oraclechain.ezwallet.modules.leftdrawer.usercenter.changename;

import com.oraclechain.ezwallet.base.BaseView;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface ChangeNameView extends BaseView {

    void updateNameDataHttp();


    void getDataHttpFail(String msg);
}
