package com.elaine.mygzh.pagenine

import com.elaine.mygzh.pagefour.Book as book

/**
 * author: elaine
 * date: 2022/3/3
 */
//vararg 可传入多个参数
fun moreParameters(vararg parameter: Int) {
    print(parameter)
}

fun testMoreParameters() {
    moreParameters(1, 3, 4)
}

//as 重命名的使用
fun testAs() {
    val myAs = book(1, "222")
}

//filter 过滤
val myList = arrayListOf(1, 2, 4, 4, -1)
val positives = myList.filter { it > 0 }

//object
object Resource {
    val name = "Name"
}

//单表达式函数
fun theAnswer() = 42

//infix
infix fun String.addAdd(count: Int): String = this + "+".repeat(count)

fun testInfix() {
    "a" addAdd 3
}

//map和flatMap
val animalsList = arrayListOf("cat", "dog", "mouse")
fun testMap() {
    animalsList.map { animal ->
        "$animal is cute，"
    }.map { animal ->
        "$animal lived."
    }

    //合并元素
    val newFlatMap = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
        .flatMap {
            it
        }
}

//zip和folder
val nameList = arrayListOf("tony", "lily")
val ageList = arrayListOf(10, 20)
val result = nameList.zip(ageList).toMap()

val result1: Int = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).fold(0) { result, item ->
    result + item
}


//generateSequence
fun testA() {
    //从2开始选1000个
    generateSequence(2) { value -> value + 1 }.take(1000)
}

