package com.zhou.beautypicture.model.main

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.*
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ImageView
import android.widget.TextView
import com.zhou.beautypicture.R
import com.zhou.beautypicture.base.BaseRecycleViewAdapter
import com.zhou.beautypicture.base.BaseRecycleViewHoldler
import com.zhou.beautypicture.model.bean.PictureDTO
import com.zhou.beautypicture.util.ImageUtil
import com.zhou.beautypicture.util.LogcatUtil
import com.zhou.beautypicture.util.ScaleImageView

/**
 * Created by zhou on 2018/4/1.
 */
class PicturesAdapter(var pictures: List<PictureDTO>) : BaseRecycleViewAdapter<PicturesAdapter.PicturesHolder>() {
    override fun getItemCount(): Int {
        return pictures.size
    }

    override fun onBindViewHolder(viewHolder: PicturesHolder?, position: Int) {
        super.onBindViewHolder(viewHolder, position)
        val picture: PictureDTO = pictures.get(position)
        viewHolder?.ivPicture?.setScale(picture.width, picture.height)
        viewHolder?.tvWho?.setText(picture.who)
        ImageUtil.loadImage(viewHolder?.itemView?.context, picture.url, viewHolder?.ivPicture)
        viewHolder?.itemView?.setOnClickListener(View.OnClickListener {
            pictureClickListener?.onClickListener(picture,position)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PicturesHolder {
        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.main_rl_item, null)

        return PicturesHolder(view)
    }

    class PicturesHolder(itemView: View) : BaseRecycleViewHoldler(itemView) {
        var ivPicture: ScaleImageView? = null
        var tvWho: TextView? = null

        init {
            ivPicture = itemView.findViewById(R.id.iv_picture)
            tvWho = itemView.findViewById(R.id.tv_who)
        }
    }

    fun setData(results: List<PictureDTO>?) {
        pictures = results!!
        this.notifyDataSetChanged()
    }

    class OnPictureScrollListener(var context: Context) : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            when (newState) {
                SCROLL_STATE_IDLE -> {//开始加载图片
                    ImageUtil.resume(context)
                }
                SCROLL_STATE_DRAGGING -> {//停止加载图片
                    ImageUtil.pause(context)
                }
                SCROLL_STATE_SETTLING -> {//停止加载图片
                    ImageUtil.pause(context)
                }
            }
        }

        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
        }
    }
    private var pictureClickListener: PictureClickListener? = null
    fun setPictureClickListener(pictureClickListener: PictureClickListener){
        this.pictureClickListener = pictureClickListener
    }
    interface PictureClickListener {
        fun onClickListener(pictureDTO: PictureDTO, position: Int)
    }
}