package com.ezeco.ezwallet.view.walletmanage;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter;
import com.ezeco.ezwallet.modules.normalvp.NormalView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * EZWalletManageActivity
 * <p>
 * Description 钱包管理主页
 *
 * @version 1.0
 * <p>
 * Ver 1.0, 2018/12/16, tanjun, Create file
 */
public class EZWalletManageActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {

    @BindView(R.id.tv_wallet_address)
    TextView tvWalletAddress;
    @BindView(R.id.tv_wallet_name)
    TextView tvWalletName;
    @BindView(R.id.rl_wallet_name)
    RelativeLayout rlWalletName;
    @BindView(R.id.rl_wallet_pwd)
    RelativeLayout rlWalletPwd;
    @BindView(R.id.rl_back_pri_key)
    RelativeLayout rlBackPriKey;
    @BindView(R.id.rl_delete_wallet)
    RelativeLayout rlDeleteWallet;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wallet_manage;
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

    @OnClick({R.id.rl_wallet_name, R.id.rl_wallet_pwd, R.id.rl_back_pri_key, R.id.rl_delete_wallet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_wallet_name:
                break;
            case R.id.rl_wallet_pwd:
                break;
            case R.id.rl_back_pri_key:
                break;
            case R.id.rl_delete_wallet:
                break;
        }
    }
}
