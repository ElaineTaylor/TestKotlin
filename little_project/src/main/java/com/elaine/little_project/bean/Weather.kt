package com.elaine.little_project.bean

/**
 *  天气
 */
data class Weather(
    val time: Long,//预报发布时间
    val now: WeatherDetail//天气详情
)
