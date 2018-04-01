package com.zhou.beautypicture.model.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.zhou.beautypicture.R
import com.zhou.beautypicture.model.bean.ResponseDTO
import com.zhou.beautypicture.util.LogcatUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.top.*

/**
 * Created by 周利杰 on 18-3-30.
 * http://gank.io/api/data/福利/10/60
 */
class MainActivity : AppCompatActivity(), MainContract.View {
    private var persion: MainContract.Persion? = null
    override fun setPersion(persion: MainContract.Persion) {
        this.persion = persion
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        MainPersion(this)
        persion!!.start()
    }

    private fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("")
        top_tv_title.setText(R.string.main_top_title)
    }

    override fun showPictures(responseDTO: ResponseDTO) {
        if (!responseDTO.error!!) {
            main_rl_picture.adapter = PicturesAdapter(responseDTO.results!!)
            main_rl_picture.setHasFixedSize(true)
            val staggeredGridLayoutManager: StaggeredGridLayoutManager? = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
//            staggeredGridLayoutManager?.isAutoMeasureEnabled = true
            staggeredGridLayoutManager?.gapStrategy=StaggeredGridLayoutManager.GAP_HANDLING_NONE
            main_rl_picture.layoutManager = staggeredGridLayoutManager
        } else LogcatUtil.d("没有图片")

    }
}