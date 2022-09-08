package com.elaine.testkotlin

import java.io.File
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.math.BigDecimal

/**
 * @author elaine
 * @date 2020/8/27
 */
class TwoUsedMethod {
    /**
     * 创建 DTOs
     */
    data class Customer(val name: String, val email: String) {
        private val sex: String? = "男"
        override fun equals(other: Any?): Boolean {
            return super.equals(other)
        }

        override fun hashCode(): Int {
            return super.hashCode()
        }

        override fun toString(): String {
            return super.toString()
        }
    }

    /**
     * 过滤 list
     */
    fun filterList() {
        val list = listOf(1, 2, -3)
        val positives = list.filter { it > 0 }
    }

    /**
     * 遍历 map/pair型list
     */
    fun initMap() {
        val map = mapOf(
            "a" to 1, "b" to 2, "c" to 3
        )
        for ((k, v) in map) {
            println("$k -> $v")

        }
        println("value=" + map["a"])
    }

    /**
     * 延迟属性 (TODO 未)
     */
    /*fun initLazy() {
        val p: String by lazy {
        }
    }*/

    /**
     * 创建单例
     */
    object Resource {
        val name = "Name"
    }

    /**
     * If not null 缩写
     */
    fun initNotNull() {
        val files = File("Test").listFiles()
        println(files?.size)
    }

    /**
     * If not null and else 缩写
     */
    fun initNotNullAndElse() {
        val files = File("Test").listFiles()
        println(files?.size ?: "empty")
    }

    /**
     * if null 执行一个语句
     */
    fun initNull() {
        val values = mapOf(
            "a" to 1, "b" to 2, "c" to 3
        )
        val email = values["email"] ?: throw IllegalStateException("Email is missing")
    }

    /**
     * if not null 执行代码 之let
     * 如果该值或其转换结果为空，那么返回 defaultValue。
     */
    fun initLet() {
        val value: String? = null
        val any = value?.let {
            //代码会执行到此处, 假如data不为null
            transform(it)
        } ?: "defaultValue"
    }

    /**
     * 返回 when 表达式
     */
    private fun transform(color: String): Int {
        return when (color) {
            "Red" -> 0
            "Green" -> 0
            "Blue" -> 2
            else -> throw  IllegalArgumentException("Invalid color param value")
        }
    }

    /**
     * 在可能会空的集合中取第一元素
     */
    fun initOneOrNull() {
        val emails = ""
        val mainEmail = emails.firstOrNull() ?: ""
    }

    /**
     * “try/catch”表达式
     */
    fun initTry() {
        val result = try {
            transform("Red")
        } catch (e: IllegalAccessException) {
            throw  IllegalArgumentException(e)
        }
    }

    /**
     * "if"表达式
     */
    fun foo(param: Int) {
        val result = if (param == 1) {
            "one"
        } else if (param == 2) {
            "two"
        } else {
            "three"
        }
    }

    /**
     * 返回类型为 Unit 的方法的 Builder 风格用法
     */
    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(-1) }
    }

    /**
     * 单表达式函数
     */
    fun theAnswer() = 42
    fun theAnswerTwo(): Int {
        return 42
    }

    /**
     * 单表达式函数与when表达式
     */
    fun transformTwo(color: String): Int = when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw  IllegalArgumentException("Invalid color param value")
    }

    /**
     * 对一个对象实例调用多个方法
     */
    fun init() {
        class Turtle {
            fun penDown() {}
            fun penUp() {}
            fun turn(degrees: Double) {}
            fun forward(pixels: Double) {}
        }

        val myTurtle = Turtle()
        with(myTurtle) {
            penDown()
            for (i in 1..4) {
                forward(100.0)
                turn(90.0)
            }
            penUp()
        }
    }

    /**
     * 配置对象的属性（apply）(TODO 未)
     */
//    val myRectangle=Rectangle().apply {
//        length=4
//        breadth=5
//        color=0xFAFAFA
//
//    }

    /**
     * 使用可空布尔
     */
    fun useBoolean() {
        val b: Boolean? = null
        if (b == true) {

        } else {
            //`b` 是 false 或者 null
        }
    }

    /**
     * 交换两个变量
     */
    fun changeVariable() {
        var a = 1
        var b = 2
        a = b.also { b = a }
    }

    /**
     * 将代码标记为不完整
     */
    fun calcTaxes(): BigDecimal = TODO("waiting for feedback from accounting")
}