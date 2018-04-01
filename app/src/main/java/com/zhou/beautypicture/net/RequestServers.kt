package com.zhou.beautypicture.net

import com.zhou.beautypicture.model.bean.PictureDTO
import com.zhou.beautypicture.model.bean.ResponseDTO

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by powerbee-z on 16-10-11.
 */
interface RequestServers {

    //根据城市名或者城市id查询天气
    @get:GET("福利/10/1")
    val pictures: Observable<ResponseDTO>


    //    @GET("v3/queries/hot")
    //    fun getHotWord():Observable<ArrayList<String>>
    fun gethot(): Observable<PictureDTO>

}
