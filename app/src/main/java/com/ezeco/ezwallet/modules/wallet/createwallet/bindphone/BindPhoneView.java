package com.ezeco.ezwallet.modules.wallet.createwallet.bindphone;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.CodeAuthBean;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface BindPhoneView extends BaseView {

    void getCodeDataHttp(String msg);

    void getCodeAuthDataHttp(CodeAuthBean.DataBean codeAuthBean);

    void getDataHttpFail(String msg);
}
