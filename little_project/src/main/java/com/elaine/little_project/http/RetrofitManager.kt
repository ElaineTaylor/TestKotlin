package com.elaine.little_project.http

import com.elaine.little_project.http.interceptor.CommonInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * Retrofit管理类
 */
object RetrofitManager {

    /**
     * okhttpClient
     */
    private val okhttpClient: OkHttpClient
        get() = OkHttpClient.Builder()
            .addInterceptor(CommonInterceptor())//通用参数拦截器
            .addInterceptor(HttpLoggingInterceptor())//日志拦截器
            .followRedirects(true)
            .build()

    /**
     * 构建service
     */
    fun <T> getService(serviceClass: Class<T>): T {
        val retrofit = Retrofit.Builder().apply {
            baseUrl(HttpConstant.BASE_HTTP)//基础访问地址
            client(okhttpClient)
            addConverterFactory(GsonConverterFactory.create())//Gson转换工厂
            addConverterFactory(ScalarsConverterFactory.create())//String转换工厂
        }.build()
        return retrofit.create(serviceClass)
    }
}