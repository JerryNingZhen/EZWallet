package com.bigstudio.ezwallet.modules.resourcemanager.changenet;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.AccountDetailsBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface ChangeNetView extends BaseView {


    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);

    void getDataHttpFail(String msg);
}
