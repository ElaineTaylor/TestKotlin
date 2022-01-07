package com.elaine.testkotlin.cainiao

/**
 *
 * author: elaine
 * date: 2021/4/29
 */
class FirstBasic {
    /**
     * 函数定义使用关键字fun，参数格式为：参数 : 类型
     */
    fun sum1(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * 表达式作为函数体，返回类型自动推断
     */
    fun sum2(a: Int, b: Int) = a + b

    /**
     * public 方法则必须明确写出返回类型
     */
    public fun sum3(a: Int, b: Int): Int = a + b

    /**
     * 无返回值的函数(类似Java中的void)
     */
    fun printSum1(a: Int, b: Int): Unit {
        print(a + b)
    }

    /**
     * 如果是返回 Unit类型，则可以省略
     * (对于public方法也是这样)
     */
    public fun printSum2(a: Int, b: Int) {
        print(a + b)
    }

    /**
     * 可变长参数函数
     *
     * 函数的变长参数可以用 vararg 关键字进行标识
     *
     * vars(1,2,3,4)--->1234
     */
    fun vars(vararg v: Int) {
        for (vt in v) {
            print(vt)
        }
    }

    /**
     * lambda(匿名函数)
     * 类型推断
     * 有参
     */
    val sumLambda = { x: Int, y: Int -> x + y }

    /**
     * lambda(匿名函数)
     * 类型推断
     * 无参
     */
    val sum = { 1 + 2 }

    /**
     *  it关键字
     */
    val myTest: (a: Int) -> Unit = {
        print("$it")
    }

    /**
     * val 不可变变量
     */
    val a: Int = 1
    val b = 1

    /**
     * var 可变变量
     */
    var x = 5

    /**
     * 字符串模板
     *
     * $varName 表示变量值
     */
    val s1 = "a is $a"

    /**
     * 字符串模板
     *
     * ${a+b}表示变量的方法返回值
     */
    val s2 = "$a +$b =${a + b}"

    /**
     * NULL检查机制
     *
     * 类型后面加?表示可为空
     */
    var age: String? = null

    /**
     * NULL检查机制
     *
     * 抛出空指针异常
     */
    val ages = age!!.toInt()

    /**
     * NULL检查机制
     *
     * 不做处理返回 null
     */
    val ages1 = age?.toInt()

    /**
     * NULL检查机制
     *
     * age为空返回-1
     */
    val ages2 = age?.toInt() ?: -1

    /**
     * NULL检查机制
     *
     *当 str 中的字符串内容不是一个整数时, 返回 null
     */
    fun fix1(str: String): Int? {
        return null
    }

    /**
     * 类型检测
     *
     * 检测一个表达式是否某类型的一个实例(类似于Java中的instanceof关键字)
     *
     * is（是）
     * !is(不是)
     */
    fun isString(a: Any): Boolean {
        return a is String
    }

    /**
     * 区间
     */
    fun rang1() {
        for (i in 1..3) print(i)//输出“1234”
        for (i in 4..1) print(i) //什么都不输出
        //使用step指定步长
        for (i in 1..4 step 2) print(i) //输出“13”
        //倒数
        for (i in 4 downTo 1 step 2) print(i) //输出“42”
        //使用until函数排除结束元素
        for (i in 1 until 10) {   //i in [1, 10) 排除了 10
            println(i)
        }
    }

    /**
     * age有默认值，可以不传
     */
    fun getStudentInfo(id: Int, name: String, age: Int = 18) {
        println("id : $id , 姓名 : $name , 年龄 : $age")
    }

    fun test() {
        getStudentInfo(1, "马冬梅")
        getStudentInfo(1, "马冬梅", 12)
        getStudentInfo(name = "马冬梅", id = 2, age = 22)

        asAParameter("马冬梅", thisStudentInfo)
    }


    /**
     * 匿名函数
     */
    private val thisStudentInfo = { id: Int, name: String ->
        "id : $id , 姓名 : $name"
    }

    /**
     * 具名函数带有匿名函数参数
     */
    private fun asAParameter(name: String, studentInfo: (Int, String) -> String) {
        println("this content created by " + studentInfo(18, name))
    }


}
