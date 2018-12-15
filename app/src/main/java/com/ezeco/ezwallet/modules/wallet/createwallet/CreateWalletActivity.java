package com.bigstudio.ezwallet.modules.wallet.createwallet;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigstudio.ezwallet.R;
import com.bigstudio.ezwallet.app.ActivityUtils;
import com.bigstudio.ezwallet.app.MyApplication;
import com.bigstudio.ezwallet.base.BaseAcitvity;
import com.bigstudio.ezwallet.bean.UserBean;
import com.bigstudio.ezwallet.gen.UserBeanDao;
import com.bigstudio.ezwallet.modules.account.createaccount.CreateAccountActivity;
import com.bigstudio.ezwallet.modules.normalvp.NormalPresenter;
import com.bigstudio.ezwallet.modules.normalvp.NormalView;
import com.bigstudio.ezwallet.modules.wallet.importwallet.ImportWalletActivity;
import com.bigstudio.ezwallet.utils.EncryptUtil;
import com.bigstudio.ezwallet.utils.PasswordToKeyUtils;
import com.bigstudio.ezwallet.utils.Utils;
import com.bigstudio.ezwallet.view.ClearEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class CreateWalletActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {


    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.password)
    ClearEditText mPassword;
    @BindView(R.id.confirm_password)
    ClearEditText mConfirmPassword;
    @BindView(R.id.create_wallet)
    Button mCreateWallet;
    @BindView(R.id.go_import_wallet)
    TextView mGoImportWallet;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_creat_wallet;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setCenterTitle(getString(R.string.creat_wallet));
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initEvent() {
        mGoImportWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.next(CreateWalletActivity.this, ImportWalletActivity.class);
            }
        });
    }

    @Override
    public NormalPresenter initPresenter() {
        return new NormalPresenter();
    }


    @OnClick(R.id.create_wallet)
    public void onViewClicked() {
        if (TextUtils.isEmpty(mPassword.getText().toString()) || TextUtils.isEmpty(mConfirmPassword.getText().toString())) {
            toast(getString(R.string.input_pwd_toast));
        } else if (mPassword.getText().toString() != null && mConfirmPassword.getText().toString() != null && mConfirmPassword.getText().toString().equals(mPassword.getText().toString())) {
            UserBean userBean = MyApplication.getDaoInstant().getUserBeanDao().queryBuilder().where(UserBeanDao.Properties.Wallet_phone.eq(Utils.getSpUtils().getString("firstUser"))).build().unique();
            if (userBean != null) {
                String randomString = EncryptUtil.getRandomString(32);
                userBean.setWallet_shapwd(PasswordToKeyUtils.shaEncrypt(randomString+mPassword.getText().toString().trim()));
                MyApplication.getDaoInstant().getUserBeanDao().update(userBean);
                MyApplication.getInstance().getUserBean().setWallet_shapwd(PasswordToKeyUtils.shaEncrypt(randomString+mPassword.getText().toString().trim()));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            ActivityUtils.next(CreateWalletActivity.this, CreateAccountActivity.class, bundle);
        } else {
            toast(getString(R.string.two_pwd));
        }
    }


}
