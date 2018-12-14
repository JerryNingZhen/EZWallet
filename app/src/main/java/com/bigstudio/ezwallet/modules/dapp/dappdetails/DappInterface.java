package com.bigstudio.ezwallet.modules.dapp.dappdetails;

import android.content.Context;
import android.webkit.JavascriptInterface;

import com.lzy.okgo.utils.OkLogger;
import com.bigstudio.ezwallet.R;
import com.bigstudio.ezwallet.app.MyApplication;
import com.bigstudio.ezwallet.blockchain.DappDatamanger;
import com.bigstudio.ezwallet.utils.PasswordToKeyUtils;
import com.bigstudio.ezwallet.utils.ShowDialog;
import com.bigstudio.ezwallet.utils.ToastUtils;
import com.bigstudio.ezwallet.view.dialog.passworddialog.PasswordCallback;
import com.bigstudio.ezwallet.view.dialog.passworddialog.PasswordDialog;
import com.bigstudio.ezwallet.view.webview.BaseWebView;

import static com.lzy.okgo.utils.HttpUtils.runOnUiThread;

/**
 * Created by pocketEos on 2018/4/25.
 */
public class DappInterface {

    private Context mContext;
    private BaseWebView mBaseWebView;

    /**
     * Instantiates a new Dapp interface.
     */
    public DappInterface(BaseWebView baseWebView, Context context) {
        this.mBaseWebView = baseWebView;
        mContext = context;
    }

    /**
     * Push action string.
     *
     * @param message           the message
     * @param permissionAccount the permission account
     * @return the string
     */
    @JavascriptInterface
    public void pushAction(String serialNumber, String message, String permissionAccount) {
        OkLogger.i("============>message" + message);
        OkLogger.i("============>serialNumber" + serialNumber);
        OkLogger.i("============>permissionAccount" + permissionAccount);
        PasswordDialog mPasswordDialog = new PasswordDialog(mContext, new PasswordCallback() {
            @Override
            public void sure(String password) {
                if (MyApplication.getInstance().getUserBean().getWallet_shapwd().equals(PasswordToKeyUtils.shaCheck(password))) {
                    ShowDialog.showDialog(mContext, "", true, null).show();
                    new DappDatamanger(mContext, password, new DappDatamanger.Callback() {
                        @Override
                        public void getTxid(String txId) {
                            OkLogger.i("=================>" + txId);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mBaseWebView.loadUrl("javascript:pushActionResult('" + serialNumber + "','" + txId + "')");
                                }
                            });
                        }

                        @Override
                        public void erroMsg(String msg) {
                            String finalMsg = "ERROR:" + msg;
                            OkLogger.i("=================>" + finalMsg);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mBaseWebView.loadUrl("javascript:pushActionResult('" + serialNumber + "','" + finalMsg + "')");
                                }
                            });
                        }
                    }).pushAction(message, permissionAccount);
                } else {
                    String msg = "ERROR:" + mContext.getResources().getString(R.string.password_error);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mBaseWebView.loadUrl("javascript:pushActionResult('" + serialNumber + "','" + msg + "')");
                        }
                    });
                    ToastUtils.showLongToast(mContext.getResources().getString(R.string.password_error));
                }

            }

            @Override
            public void cancle() {
                String msg = "ERROR:" + mContext.getResources().getString(R.string.seach_cancel);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mBaseWebView.loadUrl("javascript:pushActionResult('" + serialNumber + "','" + msg + "')");
                    }
                });
            }
        });
        mPasswordDialog.setCancelable(false);
        mPasswordDialog.show();
    }
}
