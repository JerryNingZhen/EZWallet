package com.oraclechain.ezwallet.modules.nodevote.surevote;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.ResponseBean;
import com.oraclechain.ezwallet.bean.ResultTableRowBean;
import com.oraclechain.ezwallet.bean.ResultVoteWeightBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface SureNodeVoteView extends BaseView {

    void getNowVoteWeightDataHttp(ResultVoteWeightBean resultVoteWeightBean);

    void getAccountVoteDataHttp(ResultTableRowBean resultTableRowBean);

    void postVoteTask(ResponseBean<String> data);

    void getDataHttpFail(String msg);
}
