package com.oraclechain.ezwallet.modules.nodevote;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.AccountDetailsBean;
import com.oraclechain.ezwallet.bean.ResultTableRowBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface NodeVoteView extends BaseView {

    void getAccountVoteDataHttp(ResultTableRowBean resultTableRowBean);

    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);

    void getDataHttpFail(String msg);
}
