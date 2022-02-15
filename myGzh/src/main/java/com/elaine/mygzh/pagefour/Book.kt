package com.elaine.mygzh.pagefour

/**
 * author: elaine
 * date: 2022/2/14
 */
//类属性解构
class Book(var type: Int, val name: String) {
    operator fun component1() = type
    operator fun component2() = name
}

fun testBook() {
    val (type, name) = Book(1, "数学")
    print("$type is $name")
}