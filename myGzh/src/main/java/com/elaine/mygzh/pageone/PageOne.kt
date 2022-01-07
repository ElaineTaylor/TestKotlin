package com.elaine.mygzh.pageone

import kotlin.math.roundToInt

/**
 * 第一章相关内容
 */

/**
 * 变量
 */
var a: String = "hello"
val c: Int = 2

/**
 * 类型推断
 */
class auto {
    /**
     * 变量类型
     */
    var a = 1
    var b = a

    /**
     * lambda(匿名函数)
     * 有参
     */
    val sumLambda = { x: Int, y: Int -> x + y }

    /**
     * lambda(匿名函数)
     * 无参
     */
    val sum = { 1 + 2 }
}

/**
 * in
 */
fun testIn() {
    for (i in 1..3) print(i)//输出“123”
    for (i in 3 downTo 1) print(i) // 打印结果为: "321"
    //使用step指定步长
    for (i in 1..4 step 2) print(i) //输出“13”
    //倒数
    for (i in 4 downTo 1 step 2) print(i) //输出“42”
    //使用until函数排除结束元素
    for (i in 1 until 4) {   //i in [1, 4) 排除了4
        println(i)
    }
}

/**
 * is
 */
fun testIs() {
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return null
    }
}

/**
 * when
 */
//    when (obj) {
//        1, 2 -> "number"
//        "hello" -> "string"
//        is Long -> "Long"
//        !is String -> "Not a string"
//        else -> "Unknown"
//    }

/**
 * 字符串
 */
fun testString() {
    //$变量
    val a: Int = 1
    val s1 = "a is $a"

    //${表达式}
    var b = 1
    val s2 = "a is $b"
    b = 2
    val s3 = "${s2.replace("is", "was")},but now is $b"

    //有一些前置空格
    val text1 = """
    多行字符串
    多行字符串"""

    //去除空格,从字符串中每行的开头裁剪指定的字符串参数以及前面的全部空格，如果不提供参数，则以|作为参数默认值
    val text2 = """
    |多行字符串
    |多行字符串""".trimMargin("|")

    //去除前导空格,切割每一行开头相同数量的空格
    val text3 = """
    |多行字符串
    |多行字符串""".trimIndent()

    //字符串截取
    val textA = "Hello,There is a good message."
    val indexO = textA.indexOf(",")
    val firstText = textA.substring(0, indexO)
    val twiceText = textA.subSequence(0 until indexO)//支持rang类型

    //字符串切片
    val textB = "num1,num2,num3"
    val dataB = textB.split(",")
    print("dataB[0]:" + dataB[0] + "dataB[1]:" + dataB[1] + "dataB[2]:" + dataB[2])
    val (dataB0, dataB1, dataB2) = textB.split(",")//支持解构
    print("dataB0:" + dataB0 + "dataB1:" + dataB1 + "dataB2:" + dataB2)

    //字符串替换
    val textC = "Hello,There is a good message."
    val dataC = textC.replace("e", "1")
    //支持正则表达式和匿名函数
    val dataCTwo = textC.replace(Regex("eo")) {
        when (it.value) {
            "e" -> "1"
            "o" -> "2"
            else -> it.value
        }
    }

    //字符串比较
    val textD = "hello"
    val textE = "hello"
    print(textD == textE)//ture
    print(textD === textE)//ture

    //字符串遍历
    val textF = "Hello,There is a good message."
    textF.forEach {
        print(it)
    }
}

public fun changeType() {
    //安全转化
    "1.23".toIntOrNull()
    "1".toDoubleOrNull()
    //取整
    1.23.toInt()
    //四舍五入
    1.2345.roundToInt()
    //转换成字符串
    ".2%".format(1.234567)

}

/**
 * 可空类型
 */
var b: String? = null

/**
 * 安全调用操作符
 */
fun canNull() {
    b = "elaine"
    print(b?.length)
    /**
     * 链式调用
     */
    print(b?.substring(2)?.length)
}

/**
 * let安全调用
 */
var letTwo: String? = null
var letTwoResult = letTwo?.let {
    if (it.isEmpty()) {
        "数据为空"
    } else {
        it
    }
}

/**
 * 非空断言操作符
 */
fun isNotNull() {
    print(b!!.length)
}

/**
 * 空合并操作符
 */
fun threeEyes() {
    print(b?.length ?: 0)
}

/**
 * kotlin 调用 java 的代码
 */
fun testThree() {
    print(OnePage.getMsg()?.length)
}
