package com.jindashi.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * @author 李沐阳
 * @date：2020/4/22
 * @description:
 */

fun getRetrofit(baseUrl: String?): Retrofit {
    // 正常的构建 Retrofit ，没有区别

    val builder = OkHttpClient.Builder()
    var url = "https://api.apiopen.top"
    if (baseUrl != null) url = baseUrl


    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(ApiRetrofit.getInstance().okHttpClient)
        .build()
}
