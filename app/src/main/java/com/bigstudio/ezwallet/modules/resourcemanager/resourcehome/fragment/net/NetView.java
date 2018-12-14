package com.oraclechain.ezwallet.modules.resourcemanager.resourcehome.fragment.net;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.BlockChainAccountInfoBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface NetView extends BaseView {

    void getBlockchainAccountInfoDataHttp(BlockChainAccountInfoBean.DataBean blockChainAccountInfoBean);

    void getDataHttpFail(String msg);

}
