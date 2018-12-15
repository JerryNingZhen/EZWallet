package com.ezeco.ezwallet.modules.resourcemanager.changememory;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.AccountDetailsBean;
import com.ezeco.ezwallet.bean.TableResultBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface ChangeMemoryView extends BaseView {


    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);

    void getTableDataHttp(TableResultBean.DataBean dataBean);

    void getDataHttpFail(String msg);
}
