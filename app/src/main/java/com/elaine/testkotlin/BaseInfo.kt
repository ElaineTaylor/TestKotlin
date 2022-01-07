package com.elaine.testkotlin


/**
 *@author elaine
 * 2020/7/22.
 */
class BaseInfo {
    //非空类型
    var a: String = ""

    //可空类型
    var b: String? = null

    fun test() {
        // a是非空变量，可直接调用length
        a = "taylor"
        print(a.length)
        // b是可空变量，所以需要调用安全调用操作符（?.）
        // 如果b为空则不进行length操作
        // 如果b不为空则进行length操作
        // 安全调用操作符支持链式调用
        b = "elaine"
        print(b?.length)
        print(b?.substring(2)?.length)
        // 非空断言运算符（!!）
        // 若b不为空则可以获取length
        // 若b为空则会抛出NPE（nullPointerException）
        print(b!!.length)
        // 三目条件操作符（?:）
        // 以下实现获取b的长度，如果有长度则c为长度，否则c为0
        print(b?.length ?: 0)
        val c = b?.length ?: 0


    }

    var c: Any? = 123

    //安全类型转换
    //如果c为null，参数异常则不会转换，返回null
    var d = c as? String
    var f = c as String?

    //普通类型转换
    //如果c为null，参数异常则会抛出TCE(typeCastException)
    var e = c as String

    //?.let{}
    //此函数可以忽略null值，只对非null值进行操作
    private fun doSomething(str: String) = print(str)
    fun testFour() {
        b?.let { doSomething(it) }
    }

    //如果kotlin调用java的代码，需要加上?
    //因为这样的调用破坏了Null安全性机制
    fun testThree() {
        print(BaseInfoJava.getMsg()?.length)
    }

}