package com.zhou.beautypicture.model.main

import android.content.Context
import android.graphics.Bitmap
import android.os.Handler
import android.os.Message
import com.zhou.beautypicture.model.bean.PictureDTO
import com.zhou.beautypicture.model.bean.ResponseDTO
import com.zhou.beautypicture.net.RetrofitHelper
import com.zhou.beautypicture.util.ImageUtil
import com.zhou.beautypicture.util.LogcatUtil
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * Created by zhou on 2018/3/31.
 */
class MainPersion(view: MainContract.View) : MainContract.Persion {
    private var view: MainContract.View? = null
    private var mContent: Context? = null
    //    private var persion:
    private var handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)

        }
    }

    init {
        this.view = view
        this.view!!.setPersion(this)
        this.mContent = view as Context
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
                        } else {
                            //请求成功，先获取图片大小
                            Thread(Runnable {
                                var pictureDtos = t.results
                                for (picture in pictureDtos!!) {
                                    var bitmap: Bitmap = ImageUtil.getBitmap(view as Context, picture.url)
                                    picture.width = bitmap.width
                                    picture.height = bitmap.height
                                }
                                handler.post({
                                    view?.showPictures(t)
                                })
                            }).start()
                        }
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