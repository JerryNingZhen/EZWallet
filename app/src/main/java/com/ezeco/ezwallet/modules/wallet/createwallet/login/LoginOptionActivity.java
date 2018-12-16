package com.ezeco.ezwallet.modules.wallet.createwallet.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.app.ActivityUtils;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter;
import com.ezeco.ezwallet.modules.normalvp.NormalView;
import com.ezeco.ezwallet.modules.otherloginorshare.WxShareAndLoginUtils;
import com.ezeco.ezwallet.modules.wallet.createwallet.CreateWalletOptionActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * LoginOptionActivity
 * <p>
 * Description
 *
 * @version 1.0
 * <p>
 * Ver 1.0, 2018/12/16, tanjun, Create file
 */
public class LoginOptionActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {

    @BindView(R.id.btn_wechat_login)
    Button btnWechatLogin;
    @BindView(R.id.btn_phone_login)
    Button btnPhoneLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_loginoption;

    }

    @Override
    public NormalPresenter initPresenter() {
        return new NormalPresenter();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void initEvent() {

    }

    @OnClick({R.id.btn_wechat_login, R.id.btn_phone_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_wechat_login:
                WxShareAndLoginUtils.WxLogin(this);

                break;
            case R.id.btn_phone_login:
                ActivityUtils.next(this, CreateWalletOptionActivity.class);
                break;
        }
    }
}
