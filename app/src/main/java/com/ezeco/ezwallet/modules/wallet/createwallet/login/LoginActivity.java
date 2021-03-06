package com.ezeco.ezwallet.modules.wallet.createwallet.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.app.ActivityUtils;
import com.ezeco.ezwallet.app.MyApplication;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.bean.CodeAuthBean;
import com.ezeco.ezwallet.bean.UserBean;
import com.ezeco.ezwallet.gen.UserBeanDao;
import com.ezeco.ezwallet.modules.account.createaccount.CreateAccountActivity;
import com.ezeco.ezwallet.modules.blackbox.existwalletlogin.ExistBlackBoxLoginActivity;
import com.ezeco.ezwallet.modules.blackbox.nowalletlogin.BlackBoxLoginActivity;
import com.ezeco.ezwallet.modules.leftdrawer.systemsetting.RichTextActivity;
import com.ezeco.ezwallet.modules.main.MainActivity;
import com.ezeco.ezwallet.modules.otherloginorshare.BaseUIListener;
import com.ezeco.ezwallet.modules.otherloginorshare.OtherLoginCallBack;
import com.ezeco.ezwallet.modules.otherloginorshare.QQUserInfoBean;
import com.ezeco.ezwallet.modules.otherloginorshare.WxShareAndLoginUtils;
import com.ezeco.ezwallet.modules.wallet.createwallet.CreateWalletActivity;
import com.ezeco.ezwallet.modules.wallet.createwallet.CreateWalletOptionActivity;
import com.ezeco.ezwallet.modules.wallet.createwallet.bindphone.BindPhoneActivity;
import com.ezeco.ezwallet.utils.AndroidBug5497Workaround;
import com.ezeco.ezwallet.utils.FilesUtils;
import com.ezeco.ezwallet.utils.RegexUtil;
import com.ezeco.ezwallet.utils.Utils;
import com.ezeco.ezwallet.view.ClearEditText;
import com.ezeco.ezwallet.view.countdowntimer.CountDownTimerUtils;
import com.tencent.tauth.Tencent;

import butterknife.BindView;
import butterknife.OnClick;

//登录页面
public class LoginActivity extends BaseAcitvity<LoginView, LoginPresenter> implements LoginView {
    @BindView(R.id.title)
    RelativeLayout mTitle;
    @BindView(R.id.mobile_phone)
    ClearEditText mMobilePhone;
    @BindView(R.id.sms_password)
    ClearEditText mSmsPassword;
    @BindView(R.id.create_account)
    Button mCreatNumber;
    @BindView(R.id.go_weixin_login)
    ImageView mGoWeixinLogin;
    @BindView(R.id.go_qq_login)
    ImageView mGoQqLogin;
    @BindView(R.id.get_code)
    TextView mGetCode;
    @BindView(R.id.black_box)
    TextView mBlackBox;
    @BindView(R.id.other_login_txt)
    TextView mOtherLoginTxt;
    @BindView(R.id.go_pocketeos_user)
    TextView mGoPocketeosUser;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter(LoginActivity.this);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        AndroidBug5497Workaround.assistActivity(activity);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initEvent() {
        mGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(mMobilePhone.getText().toString().trim())) {
                    if (RegexUtil.isMobileNO(mMobilePhone.getText().toString().trim())) {
                        CountDownTimerUtils countDownTimerUtils = new CountDownTimerUtils(mGetCode, 60000, 1000, "#999999");
                        countDownTimerUtils.start();
                        presenter.getCodeData(mMobilePhone.getText().toString().trim());
                    } else {
                        toast(getString(R.string.phone_format));
                    }
                } else {
                    toast(getString(R.string.phone_input));
                }
            }
        });
        mBlackBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MyApplication.getDaoInstant().getUserBeanDao().count() == 0) {//本地没有任何钱包跳转页面
                    ActivityUtils.next(LoginActivity.this, BlackBoxLoginActivity.class);
                } else {//本地存在有钱包跳转页面
                    ActivityUtils.next(LoginActivity.this, ExistBlackBoxLoginActivity.class);
                }
            }
        });
        mGoPocketeosUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("details", FilesUtils.readAssetsTxt(LoginActivity.this, "ezwallet_user"));
                bundle.putString("title", getString(R.string.setting_one));
                ActivityUtils.next(LoginActivity.this, RichTextActivity.class, bundle);
            }
        });
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.fitsSystemWindows(false).statusBarColor(R.color.transparent).titleBar(mTitle).statusBarDarkFont(false, 0f).init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideProgress();
    }

    @Override
    public void getCodeDataHttp(String msg) {
        toast(msg);
        mSmsPassword.setFocusable(true);
        mSmsPassword.setFocusableInTouchMode(true);
        mSmsPassword.requestFocus();
    }

    /** 成功后回调 */
    @Override
    public void getCodeAuthDataHttp(CodeAuthBean.DataBean codeAuthBean) {
        Utils.getSpUtils().put("firstUser", mMobilePhone.getText().toString().trim());//保存场上次登陆钱包
        Utils.getSpUtils().put("loginmode", "phone");//保存当前登录模式

        hideProgress();
        UserBean userBean0 = MyApplication.getDaoInstant().getUserBeanDao().queryBuilder().where(UserBeanDao.Properties.Wallet_phone.eq(mMobilePhone.getText().toString().trim())).build().unique();
        if (userBean0 != null) {
            toast(getString(R.string.local_wallet_exit) + mMobilePhone.getText().toString().trim() + getString(R.string.wallet));
            MyApplication.getInstance().setUserBean(userBean0);
            if (TextUtils.isEmpty(userBean0.getAccount_info())) {
                if (TextUtils.isEmpty(userBean0.getWallet_shapwd())) {
                    ActivityUtils.next(LoginActivity.this, CreateWalletActivity.class);
                } else {
                    MyApplication.getInstance().setUserBean(userBean0);
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", 1);
                    ActivityUtils.next(LoginActivity.this, CreateAccountActivity.class, bundle);
                }
            } else {
                ActivityUtils.next(LoginActivity.this, MainActivity.class, true);
            }
            MyApplication.getInstance().notificationCookie();//更新网络配置
        } else {
            //数据库存储数据
            UserBean userBean = new UserBean();
            userBean.setWallet_phone(mMobilePhone.getText().toString().trim());
            userBean.setWallet_uid(codeAuthBean.getUid());
            userBean.setWallet_name(mMobilePhone.getText().toString().trim().substring(7, 11).toString());
            MyApplication.getDaoInstant().getUserBeanDao().insert(userBean);
            MyApplication.getInstance().setUserBean(userBean);
            MyApplication.getInstance().notificationCookie();//更新网络配置
            ActivityUtils.next(LoginActivity.this, CreateWalletActivity.class);
        }
    }

    @Override
    public void getDataHttpFail(String msg) {
        hideProgress();
        toast(msg);
    }

    @OnClick({R.id.create_account, R.id.go_weixin_login, R.id.go_qq_login})
    public void onViewClicked(View view) {
        showProgress();
        switch (view.getId()) {
            case R.id.create_account:
                if (!TextUtils.isEmpty(mSmsPassword.getText().toString()) && !TextUtils.isEmpty(mMobilePhone.getText().toString().trim())) {
                    // TODO: 2018/12/15 暂时不发接口
                    // TODO: 2018/12/15 暂时放这里测试
                    getCodeAuthDataHttp(new CodeAuthBean.DataBean("d553e2e94b9b888341fe1d572b6720b5"));
                    //presenter.getcodeAuthData(mMobilePhone.getText().toString(), mSmsPassword.getText().toString());
                    ActivityUtils.next(this, CreateWalletOptionActivity.class);
                } else {
                    hideProgress();
                    toast(getString(R.string.input_all_message));
                }
                break;
            case R.id.go_weixin_login:
                WxShareAndLoginUtils.WxLogin(this);
                break;
            case R.id.go_qq_login:
                MyApplication.getInstance().getTencent().login(LoginActivity.this, "all", new BaseUIListener(LoginActivity.this, new OtherLoginCallBack() {
                    @Override
                    public void userInfoData(String openid, QQUserInfoBean qqUserInfoBean) {
                        if (openid != null && qqUserInfoBean != null) {
                            UserBean userBean = MyApplication.getDaoInstant().getUserBeanDao().queryBuilder().where(UserBeanDao.Properties.Wallet_qq.eq(openid)).build().unique();
                            if (userBean != null) {
                                toast(getString(R.string.bind_qq_wallet_exist));
                                Utils.getSpUtils().put("firstUser", userBean.getWallet_phone());//保存上次登陆钱包
                                ActivityUtils.next(LoginActivity.this, MainActivity.class, true);
                            } else {
                                Bundle bundle = new Bundle();
                                bundle.putString("openid", openid);
                                bundle.putString("type", "1");//1 代表 qq 2 代表微信
                                bundle.putParcelable("qquserInfo", qqUserInfoBean);
                                ActivityUtils.next(LoginActivity.this, BindPhoneActivity.class, bundle);
                            }
                        }
                    }
                }));
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        hideProgress();
        Tencent.onActivityResultData(requestCode, resultCode, data, new BaseUIListener());
    }

    @Override
    protected void onStop() {
        super.onStop();
        hideProgress();
    }


}
