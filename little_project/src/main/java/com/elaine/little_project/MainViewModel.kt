package com.elaine.little_project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.elaine.little_project.base.BaseViewModel
import com.elaine.little_project.bean.Weather
import com.elaine.little_project.bean.WeatherDetail
import com.elaine.little_project.data.WeatherRepository
import kotlinx.coroutines.launch

/**
 * viewModel
 */
class MainViewModel : BaseViewModel() {
    /** 天气数据 */
    var weatherData: MutableLiveData<WeatherDetail> = MutableLiveData()

    override fun start() {

    }

    /**
     * 获取天气数据
     */
    fun getWeather() {
        viewModelScope.launch {
            val result = WeatherRepository.getWeather("杭州")
            weatherData.value = result.data.now
        }
    }

}