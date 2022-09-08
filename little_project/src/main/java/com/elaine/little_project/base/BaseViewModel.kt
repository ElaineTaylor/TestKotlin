package com.elaine.little_project.base

import androidx.lifecycle.ViewModel

/**
 * 基础ViewModel
 */
abstract class BaseViewModel : ViewModel() {
    /** 初始化数据 */
    abstract fun start()
}