package com.elaine.mygzh.pageeight

import kotlin.properties.Delegates

/**
 * author: elaine
 * date: 2022/3/4
 */
//by lazy
// 第一次调用的时候会执行表达式的内容，第二调用直接使用值
val myLazy by lazy {
    print("This is First.")
    "myLazy==="
}

fun testMyLazy() {
    println(myLazy)//This is First.myLazy===
    println(myLazy)//myLazy===
}

//Observable 可以观察到数据的变化
var myObservableValue by Delegates.observable("无") { _, oldValue, newValue ->
    print("property,$oldValue,$newValue")
}

fun testMyObservableValue() {
    myObservableValue = "1111"//property,无，1111
    myObservableValue = "2222"//property,1111，2222
}

//vetoable 通过比较来决定新传入的值是否有效
var myVetoableValue: Int by Delegates.vetoable(1) { _, oldValue, newValue ->
    newValue > oldValue
}

fun testMyVetoableValue() {
    myVetoableValue = 2//2
    myVetoableValue = 5//5
    myVetoableValue = 3//5
}

//map 把属性储存在映射中
class Cup(private val map: Map<String, Any?>) {
    val color: String by map
    val capacity: Int by map
}

fun testCup() {
    val cup = Cup(mapOf("color" to "red", "capacity" to 500))
    print("$cup.color cup has ${cup.capacity} ml.") //red cup has 500 ml.
}