package com.elaine.little_project.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType
import com.elaine.little_project.BR

/**
 * 基础类Activity
 */
abstract class BaseActivity<VM : BaseViewModel, VB : ViewDataBinding>(private val contentViewResId: Int) :
    AppCompatActivity() {
    lateinit var mViewModel: VM
    lateinit var mBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        initDataBinding()
        initView()
        initData()
    }

    /**
     * 初始化ViewModel
     */
    private fun initViewModel() {
        //注意：actualTypeArguments[0] 0-->指上面BaseActivity<VM : BaseViewModel, VB : ViewDataBinding>的VM放在第一个
        val type: Class<VM> =
            (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>
        mViewModel = ViewModelProvider(this).get(type)
        mViewModel.start()
    }

    /**
     * 初始化dataBinding
     */
    private fun initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, contentViewResId)
        mBinding.apply {
            //绑定生命周期
            lifecycleOwner = this@BaseActivity
            //mBinding绑定viewModel
            setVariable(BR.viewModel, mViewModel)
        }
    }

    /**
     * 初始化UI
     */
    abstract fun initView()

    /**
     * 初始化数据
     */
    abstract fun initData()
}