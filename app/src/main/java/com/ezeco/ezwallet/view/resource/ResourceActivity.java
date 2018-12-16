package com.ezeco.ezwallet.view.resource;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.arasthel.asyncjob.AsyncJob;
import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter;
import com.ezeco.ezwallet.modules.normalvp.NormalView;
import com.google.protobuf.InvalidProtocolBufferException;

import org.tron.api.GrpcAPI;
import org.tron.protos.Contract;
import org.tron.protos.Protocol;
import org.tron.walletserver.Wallet;
import org.tron.walletserver.WalletManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * ResourceActivity
 * <p>
 * Description 用来冻结或解冻币 冻结币是来用换取能量或者是带宽
 *
 * @version 1.0
 * <p>
 * Ver 1.0, 2018/12/16, tanjun, Create file
 */
public class ResourceActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {


    @BindView(R.id.et_count)
    EditText etCount;
    @BindView(R.id.btn_bind_width)
    Button btnBindWidth;
    @BindView(R.id.btn_energy)
    Button btnEnergy;
    @BindView(R.id.btn_unfreeze_bind)
    Button btnUnfreezeBind;
    @BindView(R.id.btn_unfreeze_energy)
    Button btnUnfreezeEnergy;

    private Wallet mWallet;
    private Protocol.Account mAccount;

    /*****/
    private Protocol.Transaction mTransactionUnsigned;
    private Protocol.Transaction mTransactionSigned;

    private byte[] mTransactionBytes;
    private byte[] mExtraBytes;
    private double mTRX_Cost;
    /*****/

    private long mFreezeAmount = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_resource;
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
        byte[] address = WalletManager.decodeFromBase58Check(mWallet.getAddress());

        mAccount = WalletManager.queryAccount(address, false);
        GrpcAPI.AccountNetMessage accountNetMessage = WalletManager.getAccountNet(address);
        GrpcAPI.AccountResourceMessage accountResMessage = WalletManager.getAccountRes(address);

    }

    @Override
    public void initEvent() {

    }

    @OnClick({R.id.btn_bind_width, R.id.btn_energy, R.id.btn_unfreeze_bind, R.id.btn_unfreeze_energy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_bind_width:
                // TODO: 2018/12/16 先直接完成 后面再去做优化
                AsyncJob.doInBackground(() -> {
                    long amount = mFreezeAmount*1000000;
                    /** 带宽是true 能量是false */

                    Protocol.Transaction transaction = null;
                    try {
                        transaction = WalletManager.createFreezeBalanceTransaction(WalletManager.decodeFromBase58Check(mWallet.getAddress()), amount, 3, Contract.ResourceCode.BANDWIDTH);
                    } catch (Exception ignored) { }

                    try {
                        Protocol.Transaction finalTransaction = transaction;
                        mTransactionBytes = finalTransaction.toByteArray();
                        mTransactionUnsigned = Protocol.Transaction.parseFrom(mTransactionBytes);
                    } catch (InvalidProtocolBufferException e) {
                        e.printStackTrace();
                        finish();
                        return;
                    }

                    final boolean sent = WalletManager.broadcastTransaction(mTransactionSigned);

                });


                break;
            case R.id.btn_energy:

                break;
            case R.id.btn_unfreeze_bind:

                break;
            case R.id.btn_unfreeze_energy:

                break;
        }
    }
}
