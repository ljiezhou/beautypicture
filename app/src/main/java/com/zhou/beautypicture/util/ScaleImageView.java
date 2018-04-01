package com.zhou.beautypicture.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by zhou on 2018/4/1.
 */

@SuppressLint("AppCompatCustomView")
public class ScaleImageView extends ImageView {
    private int imageWidth;
    private int imageHeight;

    public ScaleImageView(Context context) {
        super(context);
    }

    public ScaleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScaleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScale(int width, int height) {
        this.imageWidth = width;
        this.imageHeight = height;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        LogcatUtil.d("获取到的宽：" + MeasureSpec.getSize(widthMeasureSpec) + " 获取到的高：" + MeasureSpec.getSize(heightMeasureSpec));


//        setMeasuredDimension(imageWidth, imageHeight);
        LogcatUtil.d("设置的宽：" + imageWidth + "设置的高：" + imageHeight);
    }
}
