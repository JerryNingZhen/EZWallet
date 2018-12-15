package com.ezeco.ezwallet.modules.coindetails;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.SparkLinesBean;
import com.ezeco.ezwallet.bean.TransferHistoryBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface CoinDetailsView extends BaseView {


    void getTransferHistoryDataHttp(TransferHistoryBean.DataBeanX transferHistoryBean);

    void getSparklinesData(SparkLinesBean.DataBean dataBean);


    void getDataHttpFail(String msg);
}
