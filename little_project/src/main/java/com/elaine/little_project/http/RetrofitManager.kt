package com.elaine.little_project.http

import com.elaine.little_project.http.interceptor.CommonInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitManager {

    /**
     * okhttpClient
     */
    private val okhttpClient: OkHttpClient
        get() = OkHttpClient.Builder()
            .addInterceptor(CommonInterceptor())
            .addInterceptor(HttpLoggingInterceptor())
            .followRedirects(true)
            .build()

    /**
     * 构建service
     */
    fun <T> getService(serviceClass: Class<T>): T {
        val retrofit = Retrofit.Builder().apply {
            baseUrl(HttpConstant.BASE_HTTP)
            client(okhttpClient)
            addConverterFactory(GsonConverterFactory.create())
            addConverterFactory(ScalarsConverterFactory.create())
        }.build()
        return retrofit.create(serviceClass)
    }
}