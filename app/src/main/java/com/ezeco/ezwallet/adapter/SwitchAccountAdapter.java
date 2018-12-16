package com.ezeco.ezwallet.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.ezeco.ezwallet.bean.CoinTypeBean;

import java.util.List;

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * SwitchAccountAdapter
 * <p>
 * Description
 *
 * @version 1.0
 * <p>
 * Ver 1.0, 2018/12/15, tanjun, Create file
 */
public class SwitchAccountAdapter extends RecyclerView.Adapter {

    private List<CoinTypeBean> mDatas;
    private Context mContext;

    public SwitchAccountAdapter(List<CoinTypeBean> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    private class MyHolder extends RecyclerView.ViewHolder{



        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
