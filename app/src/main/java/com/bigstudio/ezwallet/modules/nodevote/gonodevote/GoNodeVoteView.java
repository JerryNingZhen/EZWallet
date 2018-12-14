package com.bigstudio.ezwallet.modules.nodevote.gonodevote;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.ResultNodeListBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface GoNodeVoteView extends BaseView {

    void getNodeListDataHttp(ResultNodeListBean resultNodeListBean);

    void getDataHttpFail(String msg);
}
