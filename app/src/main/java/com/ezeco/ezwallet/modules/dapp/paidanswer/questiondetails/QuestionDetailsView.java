package com.bigstudio.ezwallet.modules.dapp.paidanswer.questiondetails;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.ChainInfoBean;
import com.bigstudio.ezwallet.bean.GetChainJsonBean;
import com.bigstudio.ezwallet.bean.GetRequiredKeysBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface QuestionDetailsView extends BaseView {


    void getChainInfoHttp(ChainInfoBean.DataBean chainInfoBean);

    void getChainJsonHttp(GetChainJsonBean.DataBean getChainJsonBean);

    void getRequiredKeysHttp(GetRequiredKeysBean.DataBean getRequiredKeysBean);

    void pushtransactionHttp();

    void getDataHttpFail(String msg);
}
