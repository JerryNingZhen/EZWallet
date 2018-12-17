package com.ezeco.ezwallet.view.walletmanage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter;
import com.ezeco.ezwallet.modules.normalvp.NormalView;

import org.tron.common.utils.ByteArray;
import org.tron.walletserver.Wallet;
import org.tron.walletserver.WalletManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * BackupPrikeyActivity
 * <p>
 * Description 备份私钥
 *
 * @version 1.0
 * <p>
 * Ver 1.0, 2018/12/17, tanjun, Create file
 */
public class BackupPrikeyActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {

    @BindView(R.id.tv_show_key)
    TextView tvShowKey;
    @BindView(R.id.btn_copy)
    Button btnCopy;
    @BindView(R.id.btn_backup)
    Button btnBackup;
    private Wallet mWallet;
    private String mPrivKey;

    private String name;
    private String password;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_backup_prikey;
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
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        password = bundle.getString("password");

        mWallet = WalletManager.getWallet(name, password);
        mPrivKey = ByteArray.toHexString(mWallet.getECKey().getPrivKeyBytes());
        tvShowKey.setText(mPrivKey);
    }

    @Override
    public void initEvent() {

    }

    @OnClick({R.id.btn_copy, R.id.btn_backup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_copy:

                break;
            case R.id.btn_backup:

                break;
        }
    }
}
