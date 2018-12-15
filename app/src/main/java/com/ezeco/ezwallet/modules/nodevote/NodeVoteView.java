package com.ezeco.ezwallet.modules.nodevote;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.AccountDetailsBean;
import com.ezeco.ezwallet.bean.ResultTableRowBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface NodeVoteView extends BaseView {

    void getAccountVoteDataHttp(ResultTableRowBean resultTableRowBean);

    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);

    void getDataHttpFail(String msg);
}
