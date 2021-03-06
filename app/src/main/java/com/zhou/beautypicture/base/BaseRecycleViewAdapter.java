package com.zhou.beautypicture.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zhou on 2018/4/1.
 */

public abstract class BaseRecycleViewAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T>{
    protected OnItemClickListener itemClickListener;
    protected OnItemLongClickListener itemLongClickListener;
    @Override
    public void onBindViewHolder(T viewHolder, final int position) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClickListener != null) itemClickListener.onItemClick(v, position);
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(itemLongClickListener != null) itemLongClickListener.onItemLongClick(v, position);
                return true;
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(View parent, int position);
    }
    public interface OnItemLongClickListener {
        boolean onItemLongClick(View parent, int position);
    }
    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    public void setOnItemLongClickListener(
            OnItemLongClickListener itemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener;
    }
}

