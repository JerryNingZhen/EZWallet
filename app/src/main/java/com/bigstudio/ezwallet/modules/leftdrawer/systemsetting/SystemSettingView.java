package com.bigstudio.ezwallet.modules.leftdrawer.systemsetting;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.SystemInfoBean;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface SystemSettingView extends BaseView {

    void getSystemInfoHttp(SystemInfoBean.DataBean systemInfoBean, String id);


    void getDataHttpFail(String msg);
}
