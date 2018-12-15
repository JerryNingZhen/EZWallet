package com.ezeco.ezwallet.modules.leftdrawer.transactionhistory;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.TransferHistoryBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface TransactionHistoryView extends BaseView {


    void getTransferHistoryDataHttp(TransferHistoryBean.DataBeanX transferHistoryBean);


    void getDataHttpFail(String msg);
}
