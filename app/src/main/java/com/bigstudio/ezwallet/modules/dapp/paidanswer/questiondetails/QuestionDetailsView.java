package com.oraclechain.ezwallet.modules.dapp.paidanswer.questiondetails;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.ChainInfoBean;
import com.oraclechain.ezwallet.bean.GetChainJsonBean;
import com.oraclechain.ezwallet.bean.GetRequiredKeysBean;

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
