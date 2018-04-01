package com.zhou.beautypicture.model.main

import com.zhou.beautypicture.model.bean.PictureDTO
import com.zhou.beautypicture.model.bean.ResponseDTO
import com.zhou.beautypicture.net.RetrofitHelper
import com.zhou.beautypicture.util.LogcatUtil
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * Created by zhou on 2018/3/31.
 */
class MainPersion(view: MainContract.View) : MainContract.Persion {
    private var view: MainContract.View? = null;

    //    private var persion:
    init {
        this.view = view
        this.view!!.setPersion(this)
    }

    override fun getBeautyPictures() {

    }

    override fun start() {//这样写太啰嗦，后期优化封装
        RetrofitHelper.getInstance().defaultRxApi.pictures
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<ResponseDTO>() {
                    override fun onNext(t: ResponseDTO?) {
                        LogcatUtil.d(t?.error)
                        if (t == null) {
                            LogcatUtil.d("请求失败")
                        } else view?.showPictures(t)
                    }

                    override fun onError(e: Throwable?) {
                    }

                    override fun onCompleted() {
                    }
                })
    }

    override fun detach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}