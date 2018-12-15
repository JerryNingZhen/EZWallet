package com.ezeco.ezwallet.modules.dapp.paidanswer.questiondetails;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.ChainInfoBean;
import com.ezeco.ezwallet.bean.GetChainJsonBean;
import com.ezeco.ezwallet.bean.GetRequiredKeysBean;

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
