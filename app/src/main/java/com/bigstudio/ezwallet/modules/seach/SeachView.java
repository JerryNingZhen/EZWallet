package com.bigstudio.ezwallet.modules.seach;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.BlockChainAccountInfoBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface SeachView extends BaseView {

    void getBlockchainAccountInfoDataHttp(BlockChainAccountInfoBean.DataBean blockChainAccountInfoBean);

    void getDataHttpFail(String msg);
}
