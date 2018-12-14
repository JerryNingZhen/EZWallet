package com.bigstudio.ezwallet.modules.wallet.walletmanagement;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.BaseBean;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface WalletManagementView extends BaseView {

    void setPolicyAccountHttp(BaseBean baseBean, int position);


    void getDataHttpFail(String msg);
}
