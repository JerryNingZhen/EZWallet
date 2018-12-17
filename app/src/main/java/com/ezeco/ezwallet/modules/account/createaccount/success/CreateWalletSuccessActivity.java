package com.ezeco.ezwallet.modules.account.createaccount.success;

import android.content.ClipData;
import android.content.ClipboardManager;
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
    @BindView(R.id.btn_copy)
    Button btnCopy;

    private Wallet mWallet;
    private String mPrivKey;

    private String name;
    private String password;

    private ClipboardManager clipboardManager;
    private ClipData clipData;
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
        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
    }

    @Override
    protected void initData() {
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        password = bundle.getString("password");

        /** 生成私钥 */
        mWallet = WalletManager.getWallet(name, password);

        if(mWallet == null || !mWallet.isOpen()) {
            finish();
            return;
        }

        // TODO: 2018/12/15  必须是拷贝后才可以备份
        mPrivKey = ByteArray.toHexString(mWallet.getECKey().getPrivKeyBytes());
        String mAddress = mWallet.getAddress();
        //tvShowKey.setText("私钥：" + mPrivKey + "  " + "地址" + mAddress);
        tvShowKey.setText(mPrivKey);
    }

    @Override
    public void initEvent() {

    }

    @OnClick({R.id.btn_copy, R.id.btn_backup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_copy:
                String prikey = tvShowKey.getText().toString().trim();
                clipData = ClipData.newPlainText("copy from demo", prikey);
                clipboardManager.setPrimaryClip(clipData);
                break;
            case R.id.btn_backup:

                break;
        }
    }
}
