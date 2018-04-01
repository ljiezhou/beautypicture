package com.zhou.beautypicture.model.main

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.zhou.beautypicture.R
import com.zhou.beautypicture.base.BaseRecycleViewAdapter
import com.zhou.beautypicture.base.BaseRecycleViewHoldler
import com.zhou.beautypicture.model.bean.PictureDTO
import com.zhou.beautypicture.util.ImageUtil

/**
 * Created by zhou on 2018/4/1.
 */
class PicturesAdapter(val pictures: List<PictureDTO>) : BaseRecycleViewAdapter<PicturesAdapter.PicturesHolder>() {
    override fun getItemCount(): Int {
        return pictures.size
    }

    override fun onBindViewHolder(viewHolder: PicturesHolder?, position: Int) {
        super.onBindViewHolder(viewHolder, position)
        val picture: PictureDTO = pictures.get(position)
        viewHolder?.ivPicture?.adjustViewBounds = true
        ImageUtil.loadImage(viewHolder?.itemView?.context,picture.url,viewHolder?.ivPicture)
        viewHolder?.tvWho?.setText(picture.who)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PicturesHolder {
        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.main_rl_item, null)
        return PicturesHolder(view)
    }


    class PicturesHolder(itemView: View) : BaseRecycleViewHoldler(itemView) {
        var ivPicture: ImageView? = null
        var tvWho: TextView? = null

        init {
            ivPicture = itemView.findViewById(R.id.iv_picture)
            tvWho = itemView.findViewById(R.id.tv_who)
        }
    }

}