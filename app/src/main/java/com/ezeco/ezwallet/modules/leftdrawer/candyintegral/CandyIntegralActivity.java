package com.ezeco.ezwallet.modules.leftdrawer.candyintegral;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.adapter.AdapterManger;
import com.ezeco.ezwallet.adapter.baseadapter.CommonAdapter;
import com.ezeco.ezwallet.app.MyApplication;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.bean.CandyScoreBean;
import com.ezeco.ezwallet.bean.CandyUserTaskBean;
import com.ezeco.ezwallet.bean.HotEquitiesBean;
import com.ezeco.ezwallet.view.RecycleViewDivider;
import com.ezeco.ezwallet.view.RoundImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 糖果积分系统
 */
public class CandyIntegralActivity extends BaseAcitvity<CandyIntegralView, CandyIntegralPresenter> implements CandyIntegralView {


    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.wallet_photo)
    RoundImageView mWalletPhoto;
    @BindView(R.id.my_candy_integral)
    TextView mMyCandyIntegral;
    @BindView(R.id.popular_rights)
    RecyclerView mPopularRights;
    @BindView(R.id.candy_task)
    RecyclerView mCandyTask;
    @BindView(R.id.title)
    RelativeLayout mTitle;

    private List<HotEquitiesBean.DataBean> mHotEquitiesList = new ArrayList<>(); //热门权益list
    private CommonAdapter mHotEquitiesAdapter;

    private List<CandyUserTaskBean.DataBean> mCandyTaskList = new ArrayList<>(); //任务list
    private CommonAdapter mCandyTaskAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_candy_integral;
    }

    @Override
    public CandyIntegralPresenter initPresenter() {
        return new CandyIntegralPresenter(CandyIntegralActivity.this);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        MyApplication.getInstance().showCirImage(MyApplication.getInstance().getUserBean().getWallet_img(), mWalletPhoto);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);
        mPopularRights.setLayoutManager(layoutManager);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager1.setSmoothScrollbarEnabled(true);
        mCandyTask.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.HORIZONTAL, 1, getResources().getColor(R.color.line)));
        mCandyTask.setLayoutManager(layoutManager1);

    }

    @Override
    protected void initData() {
        presenter.getCandyData();
        mHotEquitiesAdapter = AdapterManger.getHotEquitiesAdapter(this, mHotEquitiesList);
        mPopularRights.setAdapter(mHotEquitiesAdapter);
        mCandyTaskAdapter = AdapterManger.getCandyTaskAdapter(this, mCandyTaskList);
        mCandyTask.setAdapter(mCandyTaskAdapter);
    }

    @Override
    public void initEvent() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.fitsSystemWindows(false).statusBarColor(R.color.transparent).titleBar(mTitle).statusBarDarkFont(false, 0f).init();
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }


    @Override
    public void getCandyScoreDataHttp(CandyScoreBean.DataBean messageBean) {
        mMyCandyIntegral.setText("+ " + messageBean.getScoreNum());
    }

    @Override
    public void getHotEquitiesDataHttp(List<HotEquitiesBean.DataBean> mDataBeans) {
        for (int i = 0; i < mDataBeans.size(); i++) {
            HotEquitiesBean.DataBean itemdata = mDataBeans.get(i);
            mHotEquitiesList.add(itemdata);
        }
        mHotEquitiesAdapter.notifyDataSetChanged();
    }

    @Override
    public void getCandyTaskDataHttp(List<CandyUserTaskBean.DataBean> mDataBeans) {
        for (int i = 0; i < mDataBeans.size(); i++) {
            CandyUserTaskBean.DataBean itemdata = mDataBeans.get(i);
            mCandyTaskList.add(itemdata);
        }
        mCandyTaskAdapter.notifyDataSetChanged();
    }

    @Override
    public void getDataHttpFail(String msg) {
        toast(msg);
    }
}
