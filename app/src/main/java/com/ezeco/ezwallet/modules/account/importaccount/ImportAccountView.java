package com.ezeco.ezwallet.modules.account.importaccount;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.BlockChainAccountInfoBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface ImportAccountView extends BaseView {

    void getBlockchainAccountInfoDataHttp(BlockChainAccountInfoBean.DataBean blockChainAccountInfoBean);

    void setMainAccountHttp();

    void getDataHttpFail(String msg);

    void postEosAccountDataHttp();
}
