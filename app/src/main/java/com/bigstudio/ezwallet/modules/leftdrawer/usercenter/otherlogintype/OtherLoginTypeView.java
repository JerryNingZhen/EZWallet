package com.bigstudio.ezwallet.modules.leftdrawer.usercenter.otherlogintype;

import com.bigstudio.ezwallet.base.BaseView;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface OtherLoginTypeView extends BaseView {

    void unBindOtherLoginDataHttp();

    void bindOtherLoginDataHttp();

    void getDataHttpFail(String msg);
}
