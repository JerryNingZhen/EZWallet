package com.ezeco.ezwallet.modules.account.createaccount.success;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter;
import com.ezeco.ezwallet.modules.normalvp.NormalView;
import com.org.tron.common.utils.ByteArray;
import com.org.tron.walletserver.Wallet;
import com.org.tron.walletserver.WalletManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * CreateWalletSuccessActivity
 * <p>
 * Description 钱包创建成功
 *
 * @version 1.0
 * <p>
 * Ver 1.0, 2018/12/15, tanjun, Create file
 */
public class CreateWalletSuccessActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {


    @BindView(R.id.tv_show_key)
    TextView tvShowKey;
    @BindView(R.id.btn_backup)
    Button btnBackup;

    private Wallet mWallet;
    private String mPrivKey;

    private String name;
    private String password;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_success;
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
        try {
            Bundle bundle = getIntent().getExtras();
            mWallet = new Wallet(true);
            name = bundle.getString("name");
            password = bundle.getString("password");
            mWallet.setWalletName(name);

            WalletManager.store(mWallet, password);
            WalletManager.selectWallet(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Wallet wallet2 = WalletManager.getWallet(name, password);
        mPrivKey = ByteArray.toHexString(wallet2.getECKey().getPrivKeyBytes());
        String mAddress = wallet2.getAddress();
        tvShowKey.setText("私钥：" + mPrivKey + "/n" + "地址" + mAddress);

    }

    @Override
    public void initEvent() {

    }

    @OnClick(R.id.btn_backup)
    public void onViewClicked() {

    }
}
