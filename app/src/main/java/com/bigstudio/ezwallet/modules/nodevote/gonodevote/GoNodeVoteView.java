package com.oraclechain.ezwallet.modules.nodevote.gonodevote;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.ResultNodeListBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface GoNodeVoteView extends BaseView {

    void getNodeListDataHttp(ResultNodeListBean resultNodeListBean);

    void getDataHttpFail(String msg);
}
