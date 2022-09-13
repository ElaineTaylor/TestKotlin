package com.elaine.little_project

import com.elaine.little_project.base.BaseActivity
import com.elaine.little_project.databinding.ActivityMainBinding

/**
 * 主页
 */
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(R.layout.activity_main) {

    override fun initView() {

    }

    override fun initData() {
        getData()
    }

    /**
     * 获取数据
     */
    private fun getData() {
        mViewModel.getWeather()
    }

}