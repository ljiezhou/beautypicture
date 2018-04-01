package com.zhou.beautypicture.util;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by zhou on 2018/4/1.
 */

public class ImageUtil {

    public static void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

    public static void loadImage(View context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

    public static void loadImage(Activity context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

    public static void loadImage(Fragment context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

    public static void loadImage(FragmentActivity context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }
}
