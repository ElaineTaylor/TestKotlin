package com.elaine.mygzh.pagefour

/**
 * author: elaine
 * date: 2022/2/9
 */
class Teacher {
    //姓名
    var name: String? = null
        get() = field?.uppercase()
        set(value) {
            field = value?.trim()
        }

    //年纪
    var age: Int = 18
        get() {
            return field + 1
        }
        set(value) {
            field = value + 1
        }

    //性别 var定义的属性值有get和set方法
    var sex: Int = 1

    //国家 val定义的属性值只有get方法
    val nation: String = "中国"

    //幸运号码 计算属性:通过覆盖get或者set来定义
    val luckyNo
        get() = (1..100).random()
}