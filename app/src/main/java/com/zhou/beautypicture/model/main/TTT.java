package com.zhou.beautypicture.model.main;

import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhou.beautypicture.base.BaseRecycleViewAdapter;
import com.zhou.beautypicture.base.BaseRecycleViewHoldler;

import org.jetbrains.annotations.NotNull;

/**
 * Created by zhou on 2018/4/1.
 */

public class TTT extends BaseRecycleViewAdapter<RecyclerView.ViewHolder> {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    private static int i;

    public TTT(int i) {
        this.i = i;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView imageView;//new ImageView();
//        imageView.
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setli(TLi li) {
        this.setMyClickListener(new MyClickListener() {
            @Override
            public void onClick(Object o) {

            }
        });
    }

    static class TLi extends RecyclerView.OnScrollListener {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }
    }

    private MyClickListener myClickListener;

    public void setMyClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public interface MyClickListener {
        void onClick(Object o);
    }
}
