package com.zhou.beautypicture.base

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup


/**
 * Created by zhou on 2018/4/1.
 */
open class BaseRecycleViewHoldler(itemView: View): RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setLayoutParams(ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
    }
}