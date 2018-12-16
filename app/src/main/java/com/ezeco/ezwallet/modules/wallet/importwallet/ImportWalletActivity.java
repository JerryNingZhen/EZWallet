package com.ezeco.ezwallet.modules.wallet.importwallet;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.app.ActivityUtils;
import com.ezeco.ezwallet.base.BaseAcitvity;
import com.ezeco.ezwallet.modules.account.createaccount.CreateAccountActivity;
import com.ezeco.ezwallet.modules.main.MainActivity;
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter;
import com.ezeco.ezwallet.modules.normalvp.NormalView;

import org.tron.walletserver.DuplicateNameException;
import org.tron.walletserver.InvalidNameException;
import org.tron.walletserver.InvalidPasswordException;
import org.tron.walletserver.Wallet;
import org.tron.walletserver.WalletManager;

import butterknife.BindView;
import butterknife.OnClick;

//导入钱包
public class ImportWalletActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {


    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.import_pri_key)
    EditText mImportWalletEdt;
    @BindView(R.id.et_wallet_name)
    EditText mEtName;
    @BindView(R.id.et_wallet_pwd)
    EditText mWalletPwd;
    @BindView(R.id.et_wallet_pwd_again)
    EditText mWalletPwdAgain;
    @BindView(R.id.import_wallet)
    Button mImportWallet;

    private ClipboardManager mClipboardManager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_import_wallet;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setCenterTitle(getString(R.string.import_wallet));
        mClipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
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


    @OnClick({R.id.import_wallet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.import_wallet:
                Bundle bundle = new Bundle();
                bundle.putInt("type", 1);
                // TODO: 2018/12/15 后面要检测密码和私钥
                String mPwd = mWalletPwd.getText().toString().trim();
                String mPwdAgain = mWalletPwdAgain.getText().toString().trim();
                String priKey = mImportWalletEdt.getText().toString().trim();
                String walletName = mEtName.getText().toString().trim();

                try {
                    Wallet wallet = new Wallet(true);
                    wallet.setWalletName(walletName);
                    WalletManager.store(wallet, mPwd);
                    WalletManager.selectWallet(walletName);
                } catch (DuplicateNameException e) {
                    e.printStackTrace();
                } catch (InvalidPasswordException e) {
                    e.printStackTrace();
                } catch (InvalidNameException e) {
                    e.printStackTrace();
                }

                ActivityUtils.next(ImportWalletActivity.this, MainActivity.class, bundle);
                break;
        }
    }
}
