package com.elaine.mygzh.pagesix

/**
 * author: elaine
 * date: 2022/2/17
 */
//泛型函数
fun <T> getType(content: T): String {
    return when (content) {
        is Number -> "是数字"
        is String -> "是字符串"
        is Boolean -> "是波尔值"
        else -> "未知类型"
    }
}

class Phone(val name: String, val type: String) {

}

fun testGetType() {
    getType(Phone("华为手机", "鸿蒙系统"))
    getType("测试测试")
    getType(10086)
}

class ApplePhone<T>(content: T) {
    private var phone = content
    fun getInstance(): T? {
        return phone
    }

    //通过传入泛型转换成其他泛型
    fun <R> getPhone13(function: (T) -> R): R? {
        return function(phone)
    }
}



