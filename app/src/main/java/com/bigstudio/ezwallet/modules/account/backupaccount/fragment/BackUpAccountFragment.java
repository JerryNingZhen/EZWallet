package com.bigstudio.ezwallet.modules.account.backupaccount.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.bigstudio.ezwallet.R;
import com.bigstudio.ezwallet.app.ActivityUtils;
import com.bigstudio.ezwallet.app.AppManager;
import com.bigstudio.ezwallet.app.MyApplication;
import com.bigstudio.ezwallet.base.BaseFragment;
import com.bigstudio.ezwallet.bean.AccountInfoBean;
import com.bigstudio.ezwallet.modules.blackbox.BlackBoxMainActivity;
import com.bigstudio.ezwallet.modules.main.MainActivity;
import com.bigstudio.ezwallet.modules.normalvp.NormalPresenter;
import com.bigstudio.ezwallet.modules.normalvp.NormalView;
import com.bigstudio.ezwallet.utils.EncryptUtil;
import com.bigstudio.ezwallet.utils.PasswordToKeyUtils;
import com.bigstudio.ezwallet.utils.Utils;
import com.bigstudio.ezwallet.view.dialog.passworddialog.PasswordCallback;
import com.bigstudio.ezwallet.view.dialog.passworddialog.PasswordDialog;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Eos钱包备份fragment
 */
public class BackUpAccountFragment extends BaseFragment<NormalView, NormalPresenter> implements NormalView {


    @BindView(R.id.backup_title)
    TextView mBackupTitle;
    @BindView(R.id.backup_desc)
    TextView mBackupDesc;
    @BindView(R.id.switch_view)
    Switch mSwitchView;
    @BindView(R.id.details)
    TextView mDetails;
    @BindView(R.id.go_home)
    Button mGoHome;

    AccountInfoBean mAccountInfoBean = null;
    int position = 0;

    @Override
    public NormalPresenter initPresenter() {
        return new NormalPresenter();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        position = getArguments().getInt("i");
        mAccountInfoBean = getArguments().getParcelable("account");
        if (position == 0) {
            mBackupTitle.setText(R.string.backup_title_pra_key);
        } else {
            mBackupTitle.setText(R.string.backup_title_word_key);
        }

    }

    @Override
    public void initEvent() {
        mSwitchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    PasswordDialog mPasswordDialog = new PasswordDialog(getActivity(), new PasswordCallback() {
                        @Override
                        public void sure(String password) {
                            if (MyApplication.getInstance().getUserBean().getWallet_shapwd().equals(PasswordToKeyUtils.shaCheck(password))) {
                                if (position == 0) {
                                    try {
                                        mDetails.setText("OWNKEY:\n" + EncryptUtil.getDecryptString(mAccountInfoBean.getAccount_owner_private_key(),password)
                                                + "\nACTIVEKEY：\n" + EncryptUtil.getDecryptString(mAccountInfoBean.getAccount_active_private_key(),password));
                                    } catch (NoSuchAlgorithmException e) {
                                        e.printStackTrace();
                                    } catch (InvalidKeySpecException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    mDetails.setText("我是助记词");
                                }
                                mDetails.setVisibility(View.VISIBLE);
                                mSwitchView.setVisibility(View.GONE);
                                mBackupDesc.setVisibility(View.GONE);
                            }
                        }
                        @Override
                        public void cancle() {
                        }
                    });
                    mPasswordDialog.setCancelable(true);
                    mPasswordDialog.show();
                } else {
                    mDetails.setVisibility(View.GONE);
                    mSwitchView.setVisibility(View.VISIBLE);
                    mBackupDesc.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_back_up_account;
    }


    @OnClick(R.id.go_home)
    public void onViewClicked() {
          if (Utils.getSpUtils().getString("loginmode").equals("phone")) {
            ActivityUtils.next(getActivity(), MainActivity.class, true);
        } else {
            ActivityUtils.next(getActivity(), BlackBoxMainActivity.class, true);
        }
        AppManager.getAppManager().finishAllActivity();
    }
}
