package com.ezeco.ezwallet.modules.wallet.createwallet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.app.ActivityUtils;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter;
import com.ezeco.ezwallet.modules.normalvp.NormalView;
import com.ezeco.ezwallet.modules.wallet.importwallet.ImportWalletActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * CreateWalletOptionActivity
 * <p>
 * Description
 *
 * @version 1.0
 * <p>
 * Ver 1.0, 2018/12/16, tanjun, Create file
 */
public class CreateWalletOptionActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {


    @BindView(R.id.btn_import)
    Button btnImport;
    @BindView(R.id.btn_create)
    Button btnCreate;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_createwallet_option;
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

    @OnClick({R.id.btn_import, R.id.btn_create})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_import:
                ActivityUtils.next(this, ImportWalletActivity.class);
                break;
            case R.id.btn_create:

                ActivityUtils.next(this, CreateWalletActivity.class);
                break;
        }
    }
}
