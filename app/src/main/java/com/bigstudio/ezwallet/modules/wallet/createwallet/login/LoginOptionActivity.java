package com.oraclechain.ezwallet.modules.wallet.createwallet.login;

import android.os.Bundle;

import com.oraclechain.ezwallet.base.BaseAcitvity;
import com.oraclechain.ezwallet.base.BasePresent;
import com.oraclechain.ezwallet.modules.normalvp.NormalPresenter;
import com.oraclechain.ezwallet.modules.normalvp.NormalView;

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * LoginOptionActivity
 * <p>
 * Description 选择登录
 *
 * @version 1.0
 * <p>
 * Ver 1.0, 2018/12/13, tanjun, Create file
 */
public class LoginOptionActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {

    @Override
    protected int getLayoutId() {
        return 0;
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
