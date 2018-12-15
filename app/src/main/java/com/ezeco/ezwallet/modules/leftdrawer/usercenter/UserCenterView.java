package com.ezeco.ezwallet.modules.leftdrawer.usercenter;

import com.ezeco.ezwallet.base.BaseView;
import com.ezeco.ezwallet.bean.UpdataPhotoBean;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface UserCenterView extends BaseView {

    void headImgUploadaDataHttp(UpdataPhotoBean updataPhotoBean);


    void getDataHttpFail(String msg);
}
