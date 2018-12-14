package com.oraclechain.ezwallet.modules.dapp.paidanswer.paidanswerhome.fragment;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.PaidAnswerBean;

/**
 * Created by pocketEos on 2017/12/26.
 * 获取有问必答问题列表
 */
public interface PaidAnswerView extends BaseView {

    void getQuestionListDataHttp(PaidAnswerBean.DataBeanX paidAnswerBean);

    void getDataHttpFail(String msg);
}
