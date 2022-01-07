package com.elaine.mygzh.pagetwo

import android.util.Log
import kotlin.random.Random

/**
 * 第二章相关内容
 */
/**
 * 函数
 */
public fun sum(a: Int, b: Int): String {
    return "sum:${a + b}"
}

/**
 * 函数--默认值参
 */
class NotFor {
    /**
     * age有默认值，调用方法的时候可以不传
     */
    fun getStudentInfo(id: Int, name: String, age: Int = 18) {
        println("id : $id , 姓名 : $name , 年龄 : $age")
    }

//    getStudentInfo(1, "马冬梅")
//    getStudentInfo(1, "马冬梅", 12)
}

/**
 * 函数--命名值参
 */
class haveName {
    fun getStudentInfo(id: Int, name: String, age: Int = 18) {
        println("id : $id , 姓名 : $name , 年龄 : $age")
    }
//    getStudentInfo(name = "马冬梅", id = 2, age = 22)
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
class haveDetailName {
    private fun asAParameter(name: String, studentInfo: (Int, String) -> String) {
        println("this content created by " + studentInfo(18, name))
    }

//    asAParameter("马冬梅", thisStudentInfo)
}

/**
 * 作为返回
 */
class asReturn {
    /**
     * 匿名函数作为返回
     */
    private fun asReturn(): (String) -> String {
        val id = Math.random() * 10
        return { myName: String ->
            "$myName 's id is $id"
        }
    }

    fun test() {
        val asReturn = asReturn()
        print(asReturn("马冬梅"))
    }
}

/**
 * it关键字
 */
val myTest: (a: Int) -> Unit = {
    print("$it") //这里的it指a
}

/**
 * 函数引用
 */
fun quote(): String {
    return "函数引用"
}

fun testQuote() {
    print(::quote)
}

/**
 * Java的匿名内部类和kotlin的简写匿名函数
 */
fun showDrawer(content: String, who: (name: String) -> String) {
    print("this $content is draw by $who")
}

fun test() {
    showDrawer("草莓画") {
        "作家$it"
    }
}

/**
 * let
 * 返回最后一行代码
 */
fun testLet() {
    //判断是否为空，若空则不执行
    val a: String? = null
    a?.let {
        print(a.length) //打印结果
    }

    val b = "test"
    val bLength = b.let {
        it.length + 2 //复制给bLength
    }
}

/**
 * also
 * 返回对象
 */
fun testAlso() {
    val c = 2
    c.also {
        it * 2 //返回c对象，即c=4
    }
}

/**
 * run
 * 返回最后一行代码
 */

fun testRun() {
    class Student {
        val name: String? = null
        val age: Int? = null

        constructor(name: String, age: Int)
    }

    val student = Student("", 1)
    student?.run {
        print("这名学生的姓名是$name，年龄是$age") //统一做空判断
    }
}

/**
 * 例如：利用apply给列表默认首个数据
 */
fun testApply() {
    val aList = arrayListOf<String>()
    aList.apply {
        add("我是列表的头儿")//省略了aList.因为是匿名函数
    }
    Log.e("aList的size", aList.size.toString())//打印结果：aList的size: 1
}

/**
 * with
 */
fun testWith() {
    class Teacher {
        val name: String? = null
        val age: Int? = null

        constructor(name: String, age: Int)

    }

    val teacher = Teacher("陈老师", 22)
    with(teacher) {
        print("$name")
        print("$age")
    }
}

/**
 * takeIf
 * takeUnless
 */
fun testTask() {
    val random = Random.nextInt(100)
    val a = random.takeIf { it % 2 == 0 } //偶数则返回自己，否则返回null
    val b = random.takeUnless { it % 2 == 0 } //偶数则返回null，否则返回自己
    Log.e("===","a:$a,b:$b")
}

/**
 * repeat
 */
fun testRepeat() {
    var i = 0
    repeat(2) {
        i++
        Log.e("执行", "" + i)
    }
}
