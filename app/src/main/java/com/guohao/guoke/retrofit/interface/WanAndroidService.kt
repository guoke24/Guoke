package com.guohao.guoke.retrofit.`interface`

import com.guohao.guoke.retrofit.model.JsonRootBean
import retrofit2.Call
import retrofit2.http.GET


interface WanAndroidService {

    @GET("wxarticle/chapters/json")
    fun listWxarticle(): Call<JsonRootBean>

}