package com.ezeco.ezwallet.modules.transaction.transferaccounts.switchfriend;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.FriendsListInfoBean;

import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 * 获取friendslist
 */

public interface SwitchFriendView extends BaseView {

    void getDataHttp(List<FriendsListInfoBean> dataBeanList);


    void getDataHttpFail(String msg);
}
