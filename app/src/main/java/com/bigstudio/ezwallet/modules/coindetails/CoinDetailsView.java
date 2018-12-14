package com.bigstudio.ezwallet.modules.coindetails;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.SparkLinesBean;
import com.bigstudio.ezwallet.bean.TransferHistoryBean;

/**
 * Created by pocketEos on 2017/12/26.
 */
public interface CoinDetailsView extends BaseView {


    void getTransferHistoryDataHttp(TransferHistoryBean.DataBeanX transferHistoryBean);

    void getSparklinesData(SparkLinesBean.DataBean dataBean);


    void getDataHttpFail(String msg);
}
