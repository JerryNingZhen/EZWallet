package com.bigstudio.ezwallet.modules.nodevote.agencyvote;

import android.os.Bundle;

import com.bigstudio.ezwallet.R;
import com.bigstudio.ezwallet.base.BaseAcitvity;
import com.bigstudio.ezwallet.modules.normalvp.NormalPresenter;
import com.bigstudio.ezwallet.modules.normalvp.NormalView;

/**
 * 代理投票
 */
public class AgencyVoteActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_agency_vote;
    }

    @Override
    public NormalPresenter initPresenter() {
        return new NormalPresenter();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setCenterTitle(getString(R.string.go_entrust));
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initEvent() {

    }
}
