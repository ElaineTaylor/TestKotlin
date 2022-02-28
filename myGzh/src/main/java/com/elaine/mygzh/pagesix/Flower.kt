package com.elaine.mygzh.pagesix

/**
 * author: elaine
 * date: 2022/2/18
 */
//vararg，可以传入多个参数 相当于是Java的...
fun <T> getFlower(vararg flower: T) {
    val flowerArray: Array<out T> = flower
}

fun testGetFlower() {
    getFlower("a",1)
}