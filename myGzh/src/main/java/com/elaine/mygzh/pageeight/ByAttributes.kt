package com.elaine.mygzh.pageeight

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 委托属性
 * author: elaine
 * date: 2022/3/3
 */

class Example {
    var p: String by Delegate()
    val m: String by Delegate2()
    var n: String by Delegate3()
}

/**
 * 属性委托
 * var ---需要一个setValue和getValue方法
 * val ---只需要getValue方法
 */
class Delegate {
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }
}

//val 只读
class Delegate2 : ReadOnlyProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return "ReadOnlyProperty====，name:${property.name}"
    }
}

//var 可读可写
class Delegate3 : ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return "ReadWriteProperty====，name:${property.name}"
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("ReadWriteProperty====, name:${property.name} value： $value")
    }
}

fun testExample() {
    val p = Example()
    print(p.p)//Example@33a17727, thank you for delegating ‘p’ to me!
    p.p = "NEW"//NEW has been assigned to ‘p’ in Example@33a17727.

    val m = Example()
    print(m.m)//ReadOnlyProperty====，name:m

    val n = Example()
    print(n.n)//ReadWriteProperty====，name:n
    n.n = "NEW"//ReadWriteProperty====, name:n value： NEW
}