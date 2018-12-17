package com.ezeco.ezwallet.view.walletmanage;

import android.os.Bundle;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter;
import com.ezeco.ezwallet.modules.normalvp.NormalView;

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * ChangeWalletPwdActivity
 * <p>
 * Description 修改钱包密码
 *
 * @version 1.0
 * <p>
 * Ver 1.0, 2018/12/17, tanjun, Create file
 */
public class ChangeWalletPwdActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView{

    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_wallet_pwd;
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
}
