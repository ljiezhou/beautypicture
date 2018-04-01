package com.zhou.beautypicture.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.zhou.beautypicture.model.main.PicturesAdapter;

/**
 * Created by zhou on 2018/4/1.
 */

public class XRecycleView extends RecyclerView {
    public XRecycleView(Context context) {
        super(context);
        init();
    }

    public XRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public XRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        this.addOnScrollListener(new PicturesAdapter.OnPictureScrollListener(getContext()));
    }
}
