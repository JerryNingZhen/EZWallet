package com.ezeco.ezwallet.view.dialog.passworddialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.ezeco.ezwallet.R;
import com.ezeco.ezwallet.utils.ToastUtils;
import com.ezeco.ezwallet.view.ClearEditText;


/**
 * 验证钱包密码框
 */

public class DeletePasswordDialog extends Dialog implements View.OnClickListener {

    PasswordCallback callback;
    private ClearEditText mClearEditText;
    private TextView sureBtn;
    private TextView cancleBtn;
    private Context context;

    public DeletePasswordDialog(Context context, PasswordCallback callback) {
        super(context, R.style.CustomDialog);
        this.callback = callback;
        this.context = context;
        setCustomDialog();
    }

    private void setCustomDialog() {
        View mView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_password, null);
        sureBtn = (TextView) mView.findViewById(R.id.dialog_confirm_sure);
        cancleBtn = (TextView) mView.findViewById(R.id.dialog_confirm_cancle);
        mClearEditText = (ClearEditText) mView.findViewById(R.id.dialog_password);
        sureBtn.setOnClickListener(this);
        cancleBtn.setOnClickListener(this);
        super.setContentView(mView);
        WindowManager windowManager = getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.width = (int) (display.getWidth() * 0.78); //设置宽度
        this.getWindow().setAttributes(lp);
    }


    public DeletePasswordDialog setContent() {
        return this;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.dialog_confirm_cancle:
                callback.cancle();
                this.cancel();

                break;

            case R.id.dialog_confirm_sure:
                if (mClearEditText.getText().toString().trim().length() != 0) {
                    callback.sure(mClearEditText.getText().toString().trim());
                    this.cancel();
                } else {
                    ToastUtils.showShortToast(R.string.input_password);
                }
                break;
        }
    }
}
