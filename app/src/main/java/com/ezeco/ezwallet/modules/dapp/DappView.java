package com.ezeco.ezwallet.modules.dapp;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.DappBean;
import com.ezeco.ezwallet.bean.DappCommpanyBean;

import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 * 获取friendslist
 */

public interface DappView extends BaseView {
    void getDappCommpanyDataHttp(List<DappCommpanyBean.DataBean> dappCommpanyBean);

    void getDappDataHttp(List<DappBean.DataBean> dappBean);

    void getDataHttpFail(String msg);
}
