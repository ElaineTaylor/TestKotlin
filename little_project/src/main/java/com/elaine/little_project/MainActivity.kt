package com.elaine.little_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.elaine.little_project.data.WeatherRepository
import com.elaine.little_project.http.HttpConstant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    var text: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.tv)
        getData()
    }

    private fun getData() {
        MainScope().launch {
            val result = withContext(Dispatchers.IO) {
                WeatherRepository.getWeather("杭州")
            }
            text?.text = "${result.data}"
        }
    }
}