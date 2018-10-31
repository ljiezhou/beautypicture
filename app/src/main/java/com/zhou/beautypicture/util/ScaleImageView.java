package com.zhou.beautypicture.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.math.BigDecimal;

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
        int width = MeasureSpec.getSize(widthMeasureSpec);
        float scale = new BigDecimal(imageHeight).divide(new BigDecimal(imageWidth), 2, BigDecimal.ROUND_HALF_DOWN).floatValue();
        int height = (int) (width * scale);
        setMeasuredDimension(width, height);
    }
}
