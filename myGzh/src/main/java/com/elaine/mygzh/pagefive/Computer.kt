package com.elaine.mygzh.pagefive

/**
 * author: elaine
 * date: 2022/2/16
 */
//抽象类
abstract class Computer(val name: String) {
    //抽象方法
    abstract fun runSoftware()

    fun withMouse(mouseName: String) {
        print("$name 配置$mouseName 鼠标")
    }

    //open表示该方法可以被子类实现
    open fun withKeyBoard(keyBoardName: String) {
        print("$name 配置 $keyBoardName 键盘")
    }
}

class WindowComputer : Computer("window电脑") {
    //重写方法
    override fun runSoftware() {
        print("运行软件")
    }


    override fun withKeyBoard(keyBoardName: String) {
        super.withKeyBoard(keyBoardName)
        print(" $keyBoardName ")
    }
}

fun testComputer() {
    val computer: Computer = WindowComputer()
    computer.runSoftware()
    computer.withMouse("罗技鼠标")
    computer.withKeyBoard("一般键盘")
}