package com.bigstudio.ezwallet.modules.empty;

import android.os.Bundle;

import com.bigstudio.ezwallet.R;
import com.bigstudio.ezwallet.base.BaseAcitvity;
import com.bigstudio.ezwallet.modules.normalvp.NormalPresenter;
import com.bigstudio.ezwallet.modules.normalvp.NormalView;

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
