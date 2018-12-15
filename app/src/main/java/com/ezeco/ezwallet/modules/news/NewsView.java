package com.bigstudio.ezwallet.modules.news;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.CoinBean;
import com.bigstudio.ezwallet.bean.NewsBean;

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
