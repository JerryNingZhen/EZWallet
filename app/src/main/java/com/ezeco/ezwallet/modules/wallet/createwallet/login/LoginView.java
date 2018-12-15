package com.ezeco.ezwallet.modules.wallet.createwallet.login;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.CodeAuthBean;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface LoginView extends BaseView {

    void getCodeDataHttp(String message);

    void getCodeAuthDataHttp(CodeAuthBean.DataBean codeAuthBean);

    void getDataHttpFail(String msg);
}
