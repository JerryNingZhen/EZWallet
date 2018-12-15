package com.ezeco.ezwallet.modules.blackbox.existwalletlogin;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.adapter.AdapterManger;
import com.ezeco.ezwallet.adapter.baseadapter.CommonAdapter;
import com.ezeco.ezwallet.app.ActivityUtils;
import com.ezeco.ezwallet.app.AppManager;
import com.ezeco.ezwallet.app.MyApplication;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.bean.UserBean;
import com.ezeco.ezwallet.modules.account.createaccount.CreateAccountActivity;
import com.ezeco.ezwallet.modules.blackbox.BlackBoxMainActivity;
import com.ezeco.ezwallet.modules.leftdrawer.systemsetting.RichTextActivity;
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter;
import com.ezeco.ezwallet.modules.normalvp.NormalView;
import com.ezeco.ezwallet.modules.wallet.createwallet.login.LoginActivity;
import com.ezeco.ezwallet.utils.AndroidBug5497Workaround;
import com.ezeco.ezwallet.utils.FilesUtils;
import com.ezeco.ezwallet.utils.Utils;
import com.ezeco.ezwallet.view.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.ezeco.ezwallet.utils.Utils.getContext;

public class ExistBlackBoxLoginActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {


    @BindView(R.id.social_contact)
    TextView mSocialContact;
    @BindView(R.id.title)
    RelativeLayout mTitle;
    @BindView(R.id.wallet)
    RecyclerView mWallet;
    @BindView(R.id.black_box_sure)
    Button mBlackBoxSure;
    @BindView(R.id.create_a_wallet)
    TextView mCreateAWallet;
    @BindView(R.id.black_box_info)
    TextView mBlackBoxInfo;

    List<UserBean> mUserBeanList = new ArrayList<>();
    @BindView(R.id.go_pocketeos_user)
    TextView mGoPocketeosUser;
    private CommonAdapter mCommonAdapter;

    @OnClick({R.id.social_contact, R.id.black_box_sure, R.id.create_a_wallet, R.id.black_box_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.social_contact:
                AppManager.getAppManager().finishAllActivity();
                ActivityUtils.next(ExistBlackBoxLoginActivity.this, LoginActivity.class, true);
                break;
            case R.id.black_box_sure:
                if (TextUtils.isEmpty(mUserBeanList.get(AdapterManger.getSelectedPos()).getAccount_info())) {
                    Utils.getSpUtils().put("firstUser", mUserBeanList.get(AdapterManger.getSelectedPos()).getWallet_name());//保存上次登陆钱包
                    Utils.getSpUtils().put("loginmode", "blackbox");//保存当前登录模式
                    MyApplication.getInstance().setUserBean(mUserBeanList.get(AdapterManger.getSelectedPos()));
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", 1);
                    ActivityUtils.next(ExistBlackBoxLoginActivity.this, CreateAccountActivity.class);
                } else {
                    Utils.getSpUtils().put("firstUser", mUserBeanList.get(AdapterManger.getSelectedPos()).getWallet_name());//保存上次登陆钱包
                    Utils.getSpUtils().put("loginmode", "blackbox");//保存当前登录模式
                    AppManager.getAppManager().finishAllActivity();
                    ActivityUtils.next(this, BlackBoxMainActivity.class);
                }
                break;
            case R.id.create_a_wallet:
                ActivityUtils.next(this, BlackBoxCreatWalletActivity.class);
                break;
            case R.id.black_box_info:
                Bundle bundle = new Bundle();
                bundle.putString("details", FilesUtils.readAssetsTxt(this, "black_box_intro"));
                bundle.putString("title", getString(R.string.black_box));
                ActivityUtils.next(ExistBlackBoxLoginActivity.this, RichTextActivity.class, bundle);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_exist_black_box_login;
    }

    @Override
    public NormalPresenter initPresenter() {
        return new NormalPresenter();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        AndroidBug5497Workaround.assistActivity(activity);
    }

    @Override
    protected void initData() {
        mUserBeanList = MyApplication.getDaoInstant().getUserBeanDao().loadAll();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);
        mWallet.setLayoutManager(layoutManager);
        if (Utils.getSpUtils().getString("loginmode", "").equals("phone")) {
            mWallet.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL, 1, getResources().getColor(R.color.line)));
        } else {
            mWallet.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL, 1, getResources().getColor(R.color.blackbox_line)));
        }
        mCommonAdapter = AdapterManger.getWalletListAdapter(this, mUserBeanList);
        mWallet.setAdapter(mCommonAdapter);
    }

    @Override
    public void initEvent() {
        mGoPocketeosUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("details", FilesUtils.readAssetsTxt(ExistBlackBoxLoginActivity.this, "pocketeos_user"));
                bundle.putString("title", getString(R.string.setting_one));
                ActivityUtils.next(ExistBlackBoxLoginActivity.this, RichTextActivity.class, bundle);
            }
        });
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.fitsSystemWindows(false).statusBarColor(R.color.transparent).titleBar(mTitle).statusBarDarkFont(false, 0f).init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mUserBeanList.clear();
        mUserBeanList = MyApplication.getDaoInstant().getUserBeanDao().loadAll();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);
        mWallet.setLayoutManager(layoutManager);
        if (Utils.getSpUtils().getString("loginmode", "").equals("phone")) {
            mWallet.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL, 1, getResources().getColor(R.color.line)));
        } else {
            mWallet.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL, 1, getResources().getColor(R.color.blackbox_line)));
        }
        mCommonAdapter = AdapterManger.getWalletListAdapter(this, mUserBeanList);
        mWallet.setAdapter(mCommonAdapter);
    }
}
