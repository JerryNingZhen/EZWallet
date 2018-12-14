package com.bigstudio.ezwallet.modules.leftdrawer.suggestionfeedback;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.SuggestionBean;

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
