package com.oraclechain.ezwallet.modules.empty;

import android.os.Bundle;

import com.oraclechain.ezwallet.R;
import com.oraclechain.ezwallet.base.BaseAcitvity;
import com.oraclechain.ezwallet.modules.normalvp.NormalPresenter;
import com.oraclechain.ezwallet.modules.normalvp.NormalView;

public class EmptyActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_empty;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setCenterTitle("红包");
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public NormalPresenter initPresenter() {
        return new NormalPresenter();
    }
}
