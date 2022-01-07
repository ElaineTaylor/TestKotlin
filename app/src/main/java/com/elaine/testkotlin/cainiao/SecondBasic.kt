package com.elaine.testkotlin.cainiao

import android.util.Log

/**
 * author: elaine
 * date: 2021/4/29
 */
class SecondBasic {
    /**
     * 比较
     *
     * 三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小
     */
    private val a = "aaa"
    private val b = "aaa"
    private val c = "ccc"
    fun compare() {
        Log.e("compare", "${a == b}") //true
        Log.e("compare", "${a === b}") //true
        Log.e("compare", "${a === c}") //false
    }

    /**
     * 类型转换
     */
    val d = "11"
    val e: Int = d.toInt()

    /**
     * 字符
     */
    fun decimalDigitValue(c: Char): Int {
        if (c !in '0'..'9')
            throw IllegalArgumentException("Out of range")
        return c.toInt() - '0'.toInt() // 显式转换为数字
    }

    /**
     * 布尔
     *
     * || – 短路逻辑或
     * && – 短路逻辑与
     * ! - 逻辑非
     *
     */

    /**
     * 数组
     *
     * 数组的创建两种方式：一种是使用函数arrayOf()；另外一种是使用工厂函数
     * Array
     */
    val aArray = arrayOf(1, 2, 3, 4, 5)
    val bArray = Array(3) { i -> (i * 2) }
    val bData = aArray[0]

    /**
     * 字符串
     *
     * 打印
     */
    fun printString(str: String) {
        for (c in str) {
            print(c)
        }
    }

    /**
     * 字符串
     *
     * 多行字符串：三个引号 """ 扩起来的字符串
     */
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

    /**
     * 字符串模板
     *
     * 模板表达式以美元符（$）开头
     */
    val i = 10
    val s = "i= $i" //结果为 "i = 10"

    /**
     * 用花括号扩起来的任意表达式
     */
    val s2 = "runboo"
    val str = "$s2.length is ${s2.length}" //结果"runoob.length is 6"

    /**
     * 在原生字符串中表示字面值 $ 字符（它不支持反斜杠转义）
     */
    val price = """
    ${'$'}9.99
    """

}