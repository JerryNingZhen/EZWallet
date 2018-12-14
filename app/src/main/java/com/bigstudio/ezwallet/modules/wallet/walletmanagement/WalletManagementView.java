package com.oraclechain.ezwallet.modules.wallet.walletmanagement;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.BaseBean;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface WalletManagementView extends BaseView {

    void setPolicyAccountHttp(BaseBean baseBean, int position);


    void getDataHttpFail(String msg);
}
