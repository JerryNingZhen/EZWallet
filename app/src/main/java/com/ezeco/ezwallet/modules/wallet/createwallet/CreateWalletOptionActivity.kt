package com.ezeco.ezwallet.modules.wallet.createwallet

import android.os.Bundle

import com.ezeco.ezwallet.R
import com.ezeco.ezwallet.app.ActivityUtils
import com.ezeco.ezwallet.base.BaseAcitvity
import com.ezeco.ezwallet.modules.normalvp.NormalPresenter
import com.ezeco.ezwallet.modules.normalvp.NormalView
import com.ezeco.ezwallet.modules.wallet.importwallet.ImportWalletActivity
import kotlinx.android.synthetic.main.activity_createwallet_option .*

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * CreateWalletOptionActivity
 *
 *
 * Description 创建钱包选项
 *
 * @version 1.0
 *
 *
 * Ver 1.0, 2018/12/14, tanjun, Create file
 */
class CreateWalletOptionActivity : BaseAcitvity<NormalView, NormalPresenter>(), NormalView {


    override fun getLayoutId(): Int {
        return R.layout.activity_createwallet_option
    }

    override fun initPresenter(): NormalPresenter? {
        return null
    }

    override fun initViews(savedInstanceState: Bundle) {

    }

    override fun initData() {

    }

    override fun initEvent() {
        /** 导入钱包 */
        btn_import.setOnClickListener { ActivityUtils.next(this@CreateWalletOptionActivity, ImportWalletActivity::class.java) }
        /** 创建钱包 */
        btn_create.setOnClickListener { ActivityUtils.next(this@CreateWalletOptionActivity, CreateWalletActivity::class.java) }
    }
}
