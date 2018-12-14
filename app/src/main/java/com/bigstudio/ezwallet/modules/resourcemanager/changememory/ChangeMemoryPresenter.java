package com.oraclechain.ezwallet.modules.resourcemanager.changememory;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.oraclechain.ezwallet.base.BasePresent;
import com.oraclechain.ezwallet.base.BaseUrl;
import com.oraclechain.ezwallet.bean.AccountDetailsBean;
import com.oraclechain.ezwallet.bean.ResponseBean;
import com.oraclechain.ezwallet.bean.TableResultBean;
import com.oraclechain.ezwallet.net.HttpUtils;
import com.oraclechain.ezwallet.net.callbck.JsonCallback;

import java.util.HashMap;

/**
 * Created by pocketEos on 2017/12/26.
 */

public class ChangeMemoryPresenter extends BasePresent<ChangeMemoryView> {
    private Context mContext;

    public ChangeMemoryPresenter(Context context) {
        this.mContext = context;
    }
    public void getTabData(){

        HttpUtils.postRequest(BaseUrl.HTTP_eos_get_table, mContext, "{\"json\":true,\"code\":\"eosio\",\"scope\":\"eosio\",\"table\":\"rammarket\",\"table_key\":\"\",\"lower_bound\":\"\",\"upper_bound\":\"\",\"limit\":10}", new JsonCallback<ResponseBean<TableResultBean.DataBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<TableResultBean.DataBean>> response) {
                if (response.body().code == 0) {
                    view.getTableDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });

    }

    public void getAccounteData(String account) {

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", account);
        HttpUtils.postRequest(BaseUrl.HTTP_eos_get_account, mContext, hashMap, new JsonCallback<ResponseBean<AccountDetailsBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<AccountDetailsBean>> response) {
                if (response.body().code == 0) {
                    view.getAccountDetailsDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });


    }

}
