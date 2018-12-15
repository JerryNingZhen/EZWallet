package com.bigstudio.ezwallet.modules.friendslist.pelist;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.PelistBean;

import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 * 获取friendslist
 */
public interface PelistView extends BaseView {

    void getListDataHttp(List<PelistBean.DataBean> pelistBean);

    void getDataHttpFail(String msg);
}
