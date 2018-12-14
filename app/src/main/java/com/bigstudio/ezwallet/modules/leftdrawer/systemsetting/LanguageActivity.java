package com.bigstudio.ezwallet.modules.leftdrawer.systemsetting;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.bigstudio.ezwallet.R;
import com.bigstudio.ezwallet.app.ActivityUtils;
import com.bigstudio.ezwallet.app.AppManager;
import com.bigstudio.ezwallet.base.BaseAcitvity;
import com.bigstudio.ezwallet.modules.main.MainActivity;
import com.bigstudio.ezwallet.modules.normalvp.NormalPresenter;
import com.bigstudio.ezwallet.modules.normalvp.NormalView;
import com.bigstudio.ezwallet.utils.LocalManageUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class LanguageActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {

    @BindView(R.id.language_cn)
    RelativeLayout mLanguageCn;
    @BindView(R.id.language_en)
    RelativeLayout mLanguageEn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_language;
    }

    @Override
    public NormalPresenter initPresenter() {
        return new NormalPresenter();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setCenterTitle(getString(R.string.select_language));
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initEvent() {

    }


    @OnClick({R.id.language_cn, R.id.language_en})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.language_cn:
                LocalManageUtil.saveSelectLanguage(this, 1);
                AppManager.getAppManager().finishAllActivity();
                ActivityUtils.next(this, MainActivity.class);
                break;
            case R.id.language_en:
                LocalManageUtil.saveSelectLanguage(this, 2);
                AppManager.getAppManager().finishAllActivity();
                ActivityUtils.next(this, MainActivity.class);
                break;
        }
    }
}
