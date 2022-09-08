package com.elaine.little_project.data

import com.elaine.little_project.bean.CResponse
import com.elaine.little_project.bean.Weather
import com.elaine.little_project.data.api.Api
import com.elaine.little_project.http.RetrofitManager

/**
 * api接口实现类
 */
object WeatherRepository : Api {

    /** 获取service */
    private val service by lazy { RetrofitManager.getService(Api::class.java) }

    /**
     * 请求天气
     * @param area 地址 eg:杭州
     */
    override suspend fun getWeather(area: String): CResponse<Weather> {
        return service.getWeather(area)
    }
}