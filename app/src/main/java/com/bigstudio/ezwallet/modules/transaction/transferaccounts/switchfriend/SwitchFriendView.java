package com.bigstudio.ezwallet.modules.transaction.transferaccounts.switchfriend;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.FriendsListInfoBean;

import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 * 获取friendslist
 */

public interface SwitchFriendView extends BaseView {

    void getDataHttp(List<FriendsListInfoBean> dataBeanList);


    void getDataHttpFail(String msg);
}
