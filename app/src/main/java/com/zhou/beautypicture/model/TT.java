package com.zhou.beautypicture.model;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zhou.beautypicture.R;
import com.zhou.beautypicture.model.bean.PictureDTO;
import com.zhou.beautypicture.model.bean.ResponseDTO;
import com.zhou.beautypicture.model.main.MainContract;
import com.zhou.beautypicture.model.main.MainPersion;
import com.zhou.beautypicture.net.RetrofitHelper;

import org.jetbrains.annotations.NotNull;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.Subject;

/**
 * Created by 周利杰 on 18-3-30.
 */

public class TT extends AppCompatActivity implements MainContract.View{
    private TextView textView;
    private MainContract.Persion persion;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setPersion(new MainPersion());

//        RetrofitHelper.getInstance().getDefaultRxApi().getPictures().subscribe(new Subscriber<PictureDTO>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(PictureDTO o) {
//
//            }
//
//        });

//        RecyclerView recyclerView = null;
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//        });
    }

    @Override
    public void setPersion(MainContract.Persion persion) {
        this.persion = persion;
    }

    @Override
    public void showPictures(@NotNull ResponseDTO responseDTO) {

    }
}
