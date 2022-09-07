package com.elaine.little_project.bean

import com.google.gson.annotations.SerializedName

/**
 * 天气详情
 */
data class WeatherDetail(
    val aqi: String,//空气指数
    val rain: String,//下雨时间点
    val sd: String,//空气湿度
    val temperature: String,//气温
    @SerializedName("temperature_time")
    val temperatureTime: String,//获得气温的时间
    val weather: String,//天气
    @SerializedName("weather_pic")
    val weatherPic: String,//天气小图标
    @SerializedName("wind_direction")
    val windDirection: String,//风向
    @SerializedName("windPower")
    val windPower: String//风力
)
