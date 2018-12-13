package com.oraclechain.ezwallet.modules.leftdrawer.transactionhistory;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.TransferHistoryBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface TransactionHistoryView extends BaseView {


    void getTransferHistoryDataHttp(TransferHistoryBean.DataBeanX transferHistoryBean);


    void getDataHttpFail(String msg);
}
