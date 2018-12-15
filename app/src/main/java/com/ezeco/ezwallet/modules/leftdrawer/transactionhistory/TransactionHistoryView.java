package com.bigstudio.ezwallet.modules.leftdrawer.transactionhistory;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.TransferHistoryBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface TransactionHistoryView extends BaseView {


    void getTransferHistoryDataHttp(TransferHistoryBean.DataBeanX transferHistoryBean);


    void getDataHttpFail(String msg);
}
