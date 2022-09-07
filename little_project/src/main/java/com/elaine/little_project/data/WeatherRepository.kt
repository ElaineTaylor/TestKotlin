package com.elaine.little_project.data

import com.elaine.little_project.bean.CResponse
import com.elaine.little_project.bean.Weather
import com.elaine.little_project.data.api.Api
import com.elaine.little_project.http.RetrofitManager

object WeatherRepository : Api {

    private val service by lazy { RetrofitManager.getService(Api::class.java) }

    override suspend fun getWeather(area: String): CResponse<Weather> {
        return service.getWeather(area)
    }
}