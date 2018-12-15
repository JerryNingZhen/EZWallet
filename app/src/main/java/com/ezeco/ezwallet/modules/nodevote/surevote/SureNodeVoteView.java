package com.ezeco.ezwallet.modules.nodevote.surevote;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.ResponseBean;
import com.ezeco.ezwallet.bean.ResultTableRowBean;
import com.ezeco.ezwallet.bean.ResultVoteWeightBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface SureNodeVoteView extends BaseView {

    void getNowVoteWeightDataHttp(ResultVoteWeightBean resultVoteWeightBean);

    void getAccountVoteDataHttp(ResultTableRowBean resultTableRowBean);

    void postVoteTask(ResponseBean<String> data);

    void getDataHttpFail(String msg);
}
