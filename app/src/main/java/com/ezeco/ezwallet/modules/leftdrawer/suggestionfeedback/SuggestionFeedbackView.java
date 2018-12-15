package com.ezeco.ezwallet.modules.leftdrawer.suggestionfeedback;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.SuggestionBean;

import java.util.List;

/**
 * Created by pocketEos on 2017/12/26.
 * 获取friendslist
 */
public interface SuggestionFeedbackView extends BaseView {

    void postSuggestionHttp();

    void getSuggestionListHttp(List<SuggestionBean.DataBean> suggestionBean);

    void getDataHttpFail(String msg);
}
