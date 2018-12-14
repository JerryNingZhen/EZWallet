package com.bigstudio.ezwallet.modules.friendslist.myfriendslist;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.User;

import java.util.ArrayList;

/**
 * Created by pocketEos on 2017/12/26.
 * 获取friendslist
 */

public interface FriendsListView extends BaseView {

    void getDataHttp(ArrayList<User> mDataBeanArrayList);


    void getDataHttpFail(String msg);
}
