package com.zhou.beautypicture.util;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutionException;

/**
 * Created by zhou on 2018/4/1.
 */

public class ImageUtil {

    public static void pause(Context context) {
        Glide.with(context).pauseRequests();
    }

    public static void resume(Context context) {
        Glide.with(context).resumeRequests();
    }

    public static void loadImage(Context context, String url, ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).load(url).apply(requestOptions).into(imageView);
//        Picasso.with(context)
//                .load(url)
////                .transform(transformation)
//                .into(imageView);
    }

    public static Bitmap getBitmap(Context context, String url) {
        try {
            return Glide.with(context).asBitmap().load(url).submit().get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void loadImage(View context, String url, ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).load(url).apply(requestOptions).into(imageView);
    }

    public static void loadImage(Activity context, String url, ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).load(url).apply(requestOptions).into(imageView);
    }

    public static void loadImage(Fragment context, String url, ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).load(url).apply(requestOptions).into(imageView);
    }

    public static void loadImage(FragmentActivity context, String url, ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).load(url).apply(requestOptions).into(imageView);
    }
}
