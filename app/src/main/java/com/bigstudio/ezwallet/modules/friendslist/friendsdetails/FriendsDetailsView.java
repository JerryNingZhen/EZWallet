package com.bigstudio.ezwallet.modules.friendslist.friendsdetails;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.AccountWithCoinBean;
import com.bigstudio.ezwallet.bean.WalletDetailsBean;

import java.util.List;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface FriendsDetailsView extends BaseView {

    void getWalletDetailsDataHttp(List<WalletDetailsBean.DataBean> walletDetailsBean);

    void getAccountDetailsDataHttp(List<AccountWithCoinBean> mAccountWithCoinBeen);

    void getAddFollowsDataHttp();

    void getCancelFollow();

    void isfollow(Boolean isFollows);

    void getDataHttpFail(String msg);
}
