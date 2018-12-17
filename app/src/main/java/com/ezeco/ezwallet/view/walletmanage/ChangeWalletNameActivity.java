package com.ezeco.ezwallet.view.walletmanage;

import android.os.Bundle;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter;
import com.ezeco.ezwallet.modules.normalvp.NormalView;

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * ChangeWalletNameActivity
 * <p>
 * Description
 *
 * @version 1.0
 * <p>
 * Ver 1.0, 2018/12/17, tanjun, Create file
 */
public class ChangeWalletNameActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_name;
    }

    @Override
    public NormalPresenter initPresenter() {
        return null;
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
