package com.ezeco.ezwallet.modules.wallet.createwallet;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.app.ActivityUtils;
import com.ezeco.ezwallet.app.MyApplication;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.bean.UserBean;
import com.ezeco.ezwallet.gen.UserBeanDao;
import com.ezeco.ezwallet.modules.account.createaccount.success.CreateWalletSuccessActivity;
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter;
import com.ezeco.ezwallet.modules.normalvp.NormalView;
import com.ezeco.ezwallet.modules.wallet.importwallet.ImportWalletActivity;
import com.ezeco.ezwallet.utils.EncryptUtil;
import com.ezeco.ezwallet.utils.PasswordToKeyUtils;
import com.ezeco.ezwallet.utils.Utils;
import com.ezeco.ezwallet.view.ClearEditText;
import org.tron.walletserver.DuplicateNameException;
import org.tron.walletserver.InvalidNameException;
import org.tron.walletserver.InvalidPasswordException;
import org.tron.walletserver.Wallet;
import org.tron.walletserver.WalletManager;

import butterknife.BindView;
import butterknife.OnClick;

public class CreateWalletActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {


    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.et_wallet_name)
    ClearEditText mEtWalletName;
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
            // TODO: 2018/12/15
            UserBean userBean = MyApplication.getDaoInstant().getUserBeanDao().queryBuilder().where(UserBeanDao.Properties.Wallet_phone.eq(Utils.getSpUtils().getString("firstUser"))).build().unique();
            if (userBean != null) {
                String randomString = EncryptUtil.getRandomString(32);
                userBean.setWallet_shapwd(PasswordToKeyUtils.shaEncrypt(randomString+mPassword.getText().toString().trim()));
                MyApplication.getDaoInstant().getUserBeanDao().update(userBean);
                MyApplication.getInstance().getUserBean().setWallet_shapwd(PasswordToKeyUtils.shaEncrypt(randomString+mPassword.getText().toString().trim()));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            bundle.putString("password", mPassword.getText().toString());
            bundle.putString("name", mEtWalletName.getText().toString());

            try {
                Wallet wallet = new Wallet(true);
                wallet.setWalletName(mEtWalletName.getText().toString());
                //wallet.setColdWallet(coldWallet);
                WalletManager.store(wallet, mPassword.getText().toString());
                WalletManager.selectWallet(mEtWalletName.getText().toString());
            } catch (DuplicateNameException e) {
                e.printStackTrace();
            } catch (InvalidPasswordException e) {
                e.printStackTrace();
            } catch (InvalidNameException e) {
                e.printStackTrace();
            }

            //ActivityUtils.next(CreateWalletActivity.this, CreateAccountActivity.class, bundle);
            ActivityUtils.next(CreateWalletActivity.this, CreateWalletSuccessActivity.class, bundle);
        } else {
            toast(getString(R.string.two_pwd));
        }
    }


}
