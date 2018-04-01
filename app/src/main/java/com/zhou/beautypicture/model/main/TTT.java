package com.zhou.beautypicture.model.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.zhou.beautypicture.base.BaseRecycleViewAdapter;
import com.zhou.beautypicture.base.BaseRecycleViewHoldler;

import org.jetbrains.annotations.NotNull;

/**
 * Created by zhou on 2018/4/1.
 */

public class TTT extends BaseRecycleViewAdapter<RecyclerView.ViewHolder> {

    private static int i;

    public TTT(int i) {
        this.i = i;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setli(TLi li) {

    }

    static class TLi extends RecyclerView.OnScrollListener {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }
    }
}
