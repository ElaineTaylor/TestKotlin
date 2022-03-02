package com.elaine.mygzh.pageseven

/**
 * 扩展
 * author: elaine
 * date: 2022/3/1
 */
//扩展属性
val <R> List<R>.lastIndex: Int
    get() = size - 1

fun testLastIndex() {
    val myList = mutableListOf("a", "b", "c", "d")
    print(myList.lastIndex)
}

//MutableList的扩展函数--Int，交换
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // “this”对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}

//MutableList的扩展函数--支持泛型，交换
fun <T> MutableList<T>.swap2(index1: Int, index2: Int) {
    val tmp = this[index1] // “this”对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}

fun testMutableListSwap() {
    val mutableList1 = mutableListOf(1, 2, 3)
    mutableList1.swap(1, 2)
    val mutableList2 = mutableListOf("1", "2", "3")
    mutableList2.swap2(1, 2)
}

//String的扩展函数，增加","
fun String.addComma(count: Int): String = this + ",".repeat(count)

fun testStringAddComma() {
    "1234abcd".addComma(3)
}

//超类的扩展函数
fun Any.toPrint() = println(this)

fun testAnyToPrint() {
    123.toPrint()
    "arlhgi".toPrint()
}

//泛型的扩展函数
fun <T> T.toPrint2(): T {
    println(this)
    return this
}

fun testTToPrint2() {
    "3142".toPrint2()
    2.3f.toPrint2()
    "uhg".toPrint2().addComma(2).toPrint2()//支持链式调用
}

//可空类型的扩展函数
fun String?.printWithDefault(default: String) = print(this ?: default)

fun testPrintWithDefault() {
    val aa: String? = null
    aa.printWithDefault("aa is null")

    val bb = "bbbb"
    bb.printWithDefault("bb is null")
}

//伴生对象的扩展函数
class MyTestClass {
    companion object {}
}

fun MyTestClass.Companion.printCompanion() = println("printCompanion")

fun testMyTestClassPrintCompanion() {
    MyTestClass.printCompanion()
}






