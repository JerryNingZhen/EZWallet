package com.ezeco.ezwallet.modules.wallet.createwallet.login

import android.os.Bundle

import com.ezeco.ezwallet.R
import com.ezeco.ezwallet.app.ActivityUtils
import com.ezeco.ezwallet.base.BaseAcitvity
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter
import com.ezeco.ezwallet.modules.normalvp.NormalView
import com.ezeco.ezwallet.modules.otherloginorshare.WxShareAndLoginUtils
import com.ezeco.ezwallet.modules.wallet.importwallet.ImportWalletActivity
import kotlinx.android.synthetic.main.activity_loginoption .*

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * LoginOptionActivity
 *
 *
 * Description
 *
 * @version 1.0
 *
 *
 * Ver 1.0, 2018/12/14, tanjun, Create file
 */
class LoginOptionActivity : BaseAcitvity<NormalView, NormalPresenter>(), NormalView {

    override fun getLayoutId(): Int {
        return R.layout.activity_loginoption
    }

    override fun initPresenter(): NormalPresenter {
        return NormalPresenter()
    }

    override fun initViews(savedInstanceState: Bundle) {

    }

    override fun initData() {

    }

    override fun initEvent() {
        /** 微信登录 */
        btn_wechat_login.setOnClickListener { WxShareAndLoginUtils.WxLogin(this@LoginOptionActivity) }
        /** 手机号登录 */
        btn_phone_login.setOnClickListener { ActivityUtils.next(this@LoginOptionActivity, ImportWalletActivity::class.java) }

    }
}
