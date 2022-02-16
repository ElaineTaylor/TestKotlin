package com.elaine.mygzh.pagefive

/**
 * author: elaine
 * date: 2022/2/16
 */
//接口
interface Runnable {
    fun run()
}

interface Eat {

    fun eat(food: String)

    //接口已实现，则子类可以不实现
    fun eatWith() {
        print("兔子用手吃饭饭...")
    }
}

interface Wear {
    val cloth: String
}

//一个类或者对象可以实现一个或多个接口
class Rabbit : Runnable, Eat, Wear {
    //属性必须实现
    override val cloth: String = "粉色小裙子"

    override fun run() {
        print("兔子跑起来了...")
    }

    override fun eat(food: String) {
        print("兔子在吃$food")
    }

    override fun eatWith() {
        super.eatWith()
    }
}

fun testRabbit() {
    val rabbit = Rabbit()
    rabbit.run()
    rabbit.eat("胡萝卜")
    rabbit.eatWith()
}