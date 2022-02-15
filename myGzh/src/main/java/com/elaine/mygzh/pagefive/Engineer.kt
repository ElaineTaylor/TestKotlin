package com.elaine.mygzh.pagefive

/**
 * author: elaine
 * date: 2022/2/14
 */
//嵌套类
class AndroidEngineer {

    class Computer(var softerName: String) {
        fun doWork() = print("使用$softerName 软件工作")
    }
}

fun testAndroid() {
    AndroidEngineer.Computer("AndroidStudio").doWork()
}


//内部类
class IosEngineer {
    private val name: String = "ios工程师"

    inner class AppleComputer(var softerName: String) {
        //标记为 inner 的嵌套类能够访问其外部类的成员
        fun doWork() = print("$name 使用$softerName 工作")
    }
}

fun testIos() {
    IosEngineer().AppleComputer("Xcode").doWork()
}


//匿名内部类
class Button {
    private var onItemClickListenerA: OnItemClickListener? = null
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        onItemClickListenerA = onItemClickListener
    }
}

interface OnItemClickListener {
    fun onClick()
}

fun test() {
    val button = Button()
    button.setOnItemClickListener(object : OnItemClickListener {
        override fun onClick() {
            print("点击了按钮")
        }

    })
}