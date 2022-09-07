package com.elaine.testkotlin

import android.text.TextUtils
/**
 * @author elaine
 * @date 2020/8/27
 */
class OneBasicGrammar {
    /**
     * 带有两个 Int 参数、返回 Int 的函数：
     * 完整写法
     */
    fun sum1(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * 带有两个 Int 参数、返回 Int 的函数：
     * 简约写法
     * 表达式作为函数体、返回值类型自动推断
     */
    fun sum2(a: Int, b: Int) = a + b

    /**
     * 返回无意义的值
     * 字符串内插
     * Unit可省略
     */
    fun printSum(a: Int, b: Int): Unit {
        println("sum of $a and $b is ${a + b}")
    }

    /**
     * 只读类型，并指定数据类型，并立即赋值
     */
    val a: Int = 1

    /**
     * 只读类型，赋值，自动推断数据类型
     */
    val b = 2

    /**
     * 如果没有初始值类型不能省略
     * 需要明确赋值
     * 且只能作为局部变量
     */
    fun initC() {
        val c: Int
        c = 3
    }

    /**
     *  可变变量
     */
    fun initD() {
        var d = 5
        d += 1
    }

    /**
     *  顶层变量
     */
    val PI = 3.14
    var x = 0
    fun initX() {
        x += 1
    }

    /**
     * 字符串模板
     */
    fun initString() {
        var a = 1
        //模板中的简单名称：
        val s1 = "a is $a"
        a = 2
        //模板中的任意表达式：
        val s2 = "${s1.replace("is", "was")},but now is $a"
    }

    /**
     * 条件表达式
     * 完整写法
     */
    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    /**
     * 条件表达式
     * 省略写法
     */
    fun maxOfTwo(a: Int, b: Int) = if (a > b) a else b


    /**
     * 返回值可能为空，则需要将返回值加上？
     */
    fun parseInt(str: String): Int? {
        if (TextUtils.isEmpty(str)) {
            return null
        } else {
            return str.toInt()
        }
    }

    /**
     * 使用返回可空值的函数
     */
    fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        if (x == null) {
            println("Wrong number format in arg1:'$arg1'")
            return
        }
        if (y == null) {
            println("Wrong number format in arg2:'$arg2'")
            return
        }

        println(x * y)
    }

    /**
     * !is 不是； is 是
     * is 运算符检测一个表达式是否某类型的一个实例
     * 如果一个不可变的局部变量或属性已经判断出为某类型，那么检测后的分支中可以直接当作该类型使用，无需显式转换
     */
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return null
    }

    /**
     * for循环
     * 普通写法
     */
    fun unitFor() {
        val items = listOf("apple", "banana", "orange")
        for (item in items) {
            println(item)
        }
    }

    /**
     * for循环
     * index定位写法
     */
    fun unitForTwo() {
        val items = listOf("apple", "banana", "orange")
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }
    }

    /**
     * while循环
     */
    fun initWhile() {
        val items = listOf("apple", "banana", "orange")
        var index = 0
        while (index < items.size) {
            println("item at $index is ${items[index]}")
            index++
        }
    }

    /**
     * when 表达式
     */
    fun describe(obj: Any): String =
        when (obj) {
            1,2 -> "number"
            "hello" -> "string"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

    /**
     * 使用 in 运算符来检测某个数字是否在指定区间内：
     */
    fun initIn() {
        val x = 10
        val y = 9
        if (x in 1..y + 1) {
            println("fits in range")
        }
    }

    /**
     * 检测某个数字是否在指定区间外
     */
    fun initNotIn() {
        val list = listOf("a", "b", "c")
        if (-1 !in 0..list.lastIndex) {
            println("-1 is out of range")
        }
        if (list.size !in list.indices) {
            println("list size is out of valid list indices range, too")
        }
    }

    /**
     * 区间迭代
     */
    fun initInStepOne() {
        for (x in 1..5) {
            print(x)
        }
    }

    /**
     * 数列迭代
     */
    fun initInStepTwoOrThree() {
        /**
         * 间隔2进行获取
         */
        for (x in 1..10 step 2) {
            print(x)
        }
        println()
        /**
         * 倒数且间隔3进行获取
         */
        for (x in 9 downTo 0 step 3) {
            print(x)
        }
    }

    /**
     * 集合
     * 使用 lambda 表达式来过滤（filter）与映射（map）集合
     */
    fun initLambda() {
        val fruits = listOf("banana", "apple", "orange")
        fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
    }
}