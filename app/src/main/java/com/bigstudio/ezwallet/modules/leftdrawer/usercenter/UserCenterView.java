package com.oraclechain.ezwallet.modules.leftdrawer.usercenter;

import com.oraclechain.ezwallet.base.BaseView;
import com.oraclechain.ezwallet.bean.UpdataPhotoBean;

/**
 * Created by pocketEos on 2018/1/18.
 */

public interface UserCenterView extends BaseView {

    void headImgUploadaDataHttp(UpdataPhotoBean updataPhotoBean);


    void getDataHttpFail(String msg);
}
