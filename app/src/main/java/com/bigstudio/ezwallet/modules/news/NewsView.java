package com.oraclechain.ezwallet.modules.news;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.CoinBean;
import com.oraclechain.ezwallet.bean.NewsBean;

import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 * 获取friendslist
 */

public interface NewsView extends BaseView {

    void getNewsDataHttp(List<NewsBean.DataBean> newsBean);

    void getBannerDataHttp(List<NewsBean.DataBean> newsBean);

    void getCoinTypeDataHttp(List<CoinBean.DataBean> coinBeen);

    void getDataHttpFail(String msg);
}
