package com.oraclechain.ezwallet.modules.leftdrawer.messagecenter;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.MessageCenterBean;

import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 * 获取friendslist
 */
public interface MessageCenterView extends BaseView {

    void getListDataHttp(List<MessageCenterBean.DataBean> messageBean);

    void getDataHttpFail(String msg);
}
