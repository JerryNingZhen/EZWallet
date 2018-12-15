package com.bigstudio.ezwallet.modules.nodevote;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.AccountDetailsBean;
import com.bigstudio.ezwallet.bean.ResultTableRowBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface NodeVoteView extends BaseView {

    void getAccountVoteDataHttp(ResultTableRowBean resultTableRowBean);

    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);

    void getDataHttpFail(String msg);
}
