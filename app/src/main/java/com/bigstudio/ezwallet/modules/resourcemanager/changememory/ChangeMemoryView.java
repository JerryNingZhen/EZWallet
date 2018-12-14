package com.oraclechain.ezwallet.modules.resourcemanager.changememory;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.AccountDetailsBean;
import com.oraclechain.ezwallet.bean.TableResultBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface ChangeMemoryView extends BaseView {


    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);

    void getTableDataHttp(TableResultBean.DataBean dataBean);

    void getDataHttpFail(String msg);
}
