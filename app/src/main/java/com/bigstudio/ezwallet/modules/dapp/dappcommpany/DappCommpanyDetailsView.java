package com.bigstudio.ezwallet.modules.dapp.dappcommpany;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.DappBean;

import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 * 获取friendslist
 */
public interface DappCommpanyDetailsView extends BaseView {

    void getDappCommpanyDataHttp(List<DappBean.DataBean> dappBean);


    void getDataHttpFail(String msg);
}
