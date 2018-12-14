package com.oraclechain.ezwallet.modules.coindetails;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.SparkLinesBean;
import com.oraclechain.ezwallet.bean.TransferHistoryBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface CoinDetailsView extends BaseView {


    void getTransferHistoryDataHttp(TransferHistoryBean.DataBeanX transferHistoryBean);

    void getSparklinesData(SparkLinesBean.DataBean dataBean);


    void getDataHttpFail(String msg);
}
