package com.elaine.mygzh.pagefour

import android.util.Log

/**
 * author: elaine
 * date: 2022/2/10
 */
open class People(_type: String) {
    var type = _type
    open fun eat() {
        Log.e("people", "吃米饭")
    }
}

//子类继承父类
class Older : People("老人") {
    //重新方法
    override fun eat() {
        Log.e("people", "吃偏软的米饭")
    }

    fun walk() {
        Log.e("people", "散步")
    }
}

fun testPeople() {
    val people: People = Older()
    people.eat()////打印结果：people: 吃偏软的米饭

    //类型判断
    print(people is People)//true
    print(people is Older)//true

    //类型转换
    if (people is Older) {
        (people as Older).walk()
    }
}

