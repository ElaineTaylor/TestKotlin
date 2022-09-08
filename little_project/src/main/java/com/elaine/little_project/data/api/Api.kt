package com.elaine.little_project.data.api

import com.elaine.little_project.bean.CResponse
import com.elaine.little_project.bean.Weather
import retrofit2.http.*

/**
 * api接口
 */
interface Api {

    /**
     * 请求天气
     * @param area 地址 eg:杭州
     */
    @FormUrlEncoded
    @POST("/9-2")
    suspend fun getWeather(
        @Field("area") area: String,
    ): CResponse<Weather>
}