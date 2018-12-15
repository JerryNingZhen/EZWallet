package com.ezeco.ezwallet.modules.leftdrawer.candyintegral;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.CandyScoreBean;
import com.ezeco.ezwallet.bean.CandyUserTaskBean;
import com.ezeco.ezwallet.bean.HotEquitiesBean;

import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 * 获取friendslist
 */
public interface CandyIntegralView extends BaseView {

    void getCandyScoreDataHttp(CandyScoreBean.DataBean messageBean);

    void getHotEquitiesDataHttp(List<HotEquitiesBean.DataBean> mDataBeans);

    void getCandyTaskDataHttp(List<CandyUserTaskBean.DataBean> mDataBeans);

    void getDataHttpFail(String msg);
}
