package com.zhou.beautypicture.model.main

import com.zhou.beautypicture.base.BasePersion
import com.zhou.beautypicture.base.BaseView
import com.zhou.beautypicture.model.bean.ResponseDTO

/**
 * Created by zhou on 2018/3/31.
 */
interface MainContract {
    interface View : BaseView<Persion> {
        fun showPictures(responseDTO: ResponseDTO)
    }

    interface Persion : BasePersion {
        fun getBeautyPictures()
    }
}