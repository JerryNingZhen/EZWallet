package com.ezeco.ezwallet.view.walletmanage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.app.ActivityUtils;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter;
import com.ezeco.ezwallet.modules.normalvp.NormalView;
import com.ezeco.ezwallet.view.dialog.passworddialog.PasswordDialog;

import org.tron.common.utils.ByteArray;
import org.tron.walletserver.Wallet;
import org.tron.walletserver.WalletManager;

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

    private PasswordDialog dialog;
    // TODO: 2018/12/17 暂时用这个钱包 后面的开发中用的是上一个界面传过来的数据
    private Wallet mWallet;
    private String mAdress;
    private String mPriKey;
    private String mWalletName;

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
        mWallet = WalletManager.getSelectedWallet();

        mWalletName = mWallet.getWalletName();
        mAdress = mWallet.getAddress();
        mPriKey = ByteArray.toHexString(mWallet.getECKey().getPrivKeyBytes());

        tvWalletAddress.setText(mAdress);
        tvWalletName.setText(mWalletName);
    }

    @Override
    public void initEvent() {

    }

    @OnClick({R.id.rl_wallet_name, R.id.rl_wallet_pwd, R.id.rl_back_pri_key, R.id.rl_delete_wallet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_wallet_name:
                ActivityUtils.next(this, ChangeWalletNameActivity.class);
                break;
            case R.id.rl_wallet_pwd:
                ActivityUtils.next(this, ChangeWalletPwdActivity.class);
                break;
            case R.id.rl_back_pri_key:


                ActivityUtils.next(this, BackupPrikeyActivity.class);

                break;
            case R.id.rl_delete_wallet:

                break;
        }
    }
}
