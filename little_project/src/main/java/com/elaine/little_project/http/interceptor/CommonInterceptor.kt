package com.elaine.little_project.http.interceptor

import com.elaine.little_project.http.HttpConstant
import okhttp3.Interceptor
import okhttp3.Response

/**
 * 通用参数拦截器
 */
class CommonInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val oldRequest = chain.request()
        val httUrl = oldRequest.url
        val urlBuilder = httUrl.newBuilder()

        /** 添加公共参数 */
        urlBuilder.addQueryParameter("showapi_appid", HttpConstant.APP_ID)
        urlBuilder.addQueryParameter("showapi_sign", HttpConstant.APP_SIGN)

        val request = oldRequest
            .newBuilder()
            .url(urlBuilder.build())
            .build()
        return chain.proceed(request)
    }
}