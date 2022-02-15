package com.elaine.mygzh.pagefive

/**
 * author: elaine
 * date: 2022/2/14
 */
//数据类
data class Cup(var color: String, var material: String) {
    //类内部属性
    var birth: Int = 1900
}

fun testCup() {

    //==比较的是内容，因为数据类重写了equals方法
    //===比较的是引用
    print(Cup("红色", "陶瓷") == Cup("红色", "陶瓷"))//true
    print(Cup("红色", "陶瓷") === Cup("红色", "陶瓷"))//false

    val cup = Cup("绿色", "陶瓷")

    //copy拷贝对象
    val cupTwo = cup.copy(color = "黄色")

    //直接引用解构
    print("${cup.color} 的颜色的杯子是用 ${cup.material} 做的")

    //类内部属性不影响比较
    val cupA = Cup("红色", "陶瓷")
    val cupB = Cup("红色", "陶瓷")
    cupA.birth = 1901
    cupB.birth = 1902
    print(cupA == cupB) //true
}