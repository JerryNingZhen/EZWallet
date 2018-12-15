package com.bigstudio.ezwallet.modules.resourcemanager.changememory;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.AccountDetailsBean;
import com.bigstudio.ezwallet.bean.TableResultBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface ChangeMemoryView extends BaseView {


    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);

    void getTableDataHttp(TableResultBean.DataBean dataBean);

    void getDataHttpFail(String msg);
}
