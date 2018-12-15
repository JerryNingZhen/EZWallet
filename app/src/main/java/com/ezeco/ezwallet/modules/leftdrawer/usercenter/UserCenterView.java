package com.bigstudio.ezwallet.modules.leftdrawer.usercenter;

import com.bigstudio.ezwallet.base.BaseView;
import com.bigstudio.ezwallet.bean.UpdataPhotoBean;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface UserCenterView extends BaseView {

    void headImgUploadaDataHttp(UpdataPhotoBean updataPhotoBean);


    void getDataHttpFail(String msg);
}
