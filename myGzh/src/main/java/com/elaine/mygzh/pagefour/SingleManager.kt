package com.elaine.mygzh.pagefour

/**
 * author: elaine
 * date: 2022/2/10
 */
//单例
object SingleManager {
    //类方法
    fun getSingleName(): String {
        return "单例名字"
    }
}

fun testSingleManager() {
    //单例使用
    print(SingleManager.getSingleName())
}

//对象
open class Phone {
    open fun call() = "可以打电话"
}

fun testPhone() {
    //表达式
    val androidPhone = object : Phone() {
        override fun call(): String = "安卓手机可以打电话"
    }
    print(androidPhone.call())
}

//伴生对象
open class LuckNum {

    companion object {
        private const val luckyNo = "10008"

        fun load() = "测试$luckyNo"
    }

}

fun testLuckNum() {
    LuckNum.load()
}

