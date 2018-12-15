package com.bigstudio.ezwallet.modules.nodevote.surevote;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.ResponseBean;
import com.bigstudio.ezwallet.bean.ResultTableRowBean;
import com.bigstudio.ezwallet.bean.ResultVoteWeightBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface SureNodeVoteView extends BaseView {

    void getNowVoteWeightDataHttp(ResultVoteWeightBean resultVoteWeightBean);

    void getAccountVoteDataHttp(ResultTableRowBean resultTableRowBean);

    void postVoteTask(ResponseBean<String> data);

    void getDataHttpFail(String msg);
}
