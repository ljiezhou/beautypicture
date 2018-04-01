package com.zhou.beautypicture.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.zhou.beautypicture.base.BaseRecycleViewAdapter;
import com.zhou.beautypicture.base.BaseRecycleViewHoldler;

import org.jetbrains.annotations.NotNull;

/**
 * Created by zhou on 2018/4/1.
 */

public class Pictureadapter extends BaseRecycleViewAdapter<Pictureadapter.Holder> {

    @Override
    public Pictureadapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Holder extends BaseRecycleViewHoldler{

        public Holder(@NotNull View itemView) {
            super(itemView);
        }
    }
}
