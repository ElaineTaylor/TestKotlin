package com.elaine.mygzh.pagesix

/**
 * author: elaine
 * date: 2022/2/17
 */
//泛型类
class Box<T>(t: T) {
    var value = t
}

class Water {

}

fun testBox() {
    //T类型为字符串
    val can1 = Box("字符串")
    //T类型为Water对象
    val can2 = Box(Water())
    //T类型为整型
    val can3 = Box(1)
}