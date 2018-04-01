package com.zhou.beautypicture.model.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.zhou.beautypicture.R
import com.zhou.beautypicture.model.bean.PictureDTO
import com.zhou.beautypicture.model.bean.ResponseDTO
import com.zhou.beautypicture.util.ImageUtil
import com.zhou.beautypicture.util.LogcatUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.top.*

/**
 * Created by 周利杰 on 18-3-30.
 * http://gank.io/api/data/福利/10/60
 */
class MainActivity : AppCompatActivity(), MainContract.View {
    private var persion: MainContract.Persion? = null
    private var adapter: PicturesAdapter? = null
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
        adapter = PicturesAdapter(ArrayList<PictureDTO>())
        val staggeredGridLayoutManager: StaggeredGridLayoutManager? = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        staggeredGridLayoutManager?.gapStrategy=StaggeredGridLayoutManager.GAP_HANDLING_NONE
        staggeredGridLayoutManager?.isAutoMeasureEnabled = true
        main_rl_picture.layoutManager = staggeredGridLayoutManager
        main_rl_picture.setHasFixedSize(true)
//        main_rl_picture.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                // State有三种状态：SCROLL_STATE_IDLE（静止）、SCROLL_STATE_DRAGGING（上升）、SCROLL_STATE_SETTLING（下落）
//                if (newState == SCROLL_STATE_IDLE) {
//                    adapter?.setScrolling(false)
//                    ImageUtil.resume(this@MainActivity)
////                        adapter?.notifyDataSetChanged()
//                } else {
//                    adapter?.setScrolling(true)
//                    ImageUtil.pause(this@MainActivity)
//                }
//            }
//        })
    }

    override fun showPictures(responseDTO: ResponseDTO) {
        if (!responseDTO.error!!) {
            adapter?.setData(responseDTO.results)
            main_rl_picture.adapter = adapter
        } else LogcatUtil.d("没有图片")

    }
}