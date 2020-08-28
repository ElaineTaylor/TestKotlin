package com.elaine.testkotlin

/**
 * @author elaine
 * @date 2020/8/28
 */
class FiveControlFlow {
    /**
     * if
     */
    fun initIf(a: Int, b: Int) {
        //传统写法
        var maxOne = a
        if (a < b) maxOne = b

        //with else
        val maxTwo: Int
        if (a > b) {
            maxTwo = a
        } else {
            maxTwo = b
        }

        //作为表达式
        val maxThree = if (a > b) a else b

        //分支是代码块
        val maxFour = if (a > b) {
            print("Choose a")
            a
        } else {
            print("Choose b")
            b
        }
    }

    /**
     * when
     */
    fun initWhen(x: Int, y: Boolean) {
        when (x) {
            1 -> print("x==1")
            2 -> print("x==2")
            3, 4 -> print("x is 3 or 4") //合并多个分支
            else -> {
                print("x is neither 1 nor 2")
            }
        }

        when (y) {
            is2(6) -> print("能被2整除") //表达式作为分支条件
            else -> print("不能被2整除")
        }

        /**
         * 用区间作为分支
         */
        when (x) {
            in 1..10 -> print("x is in the range")
            !in 10..20 -> print("x is outside the range")
            else -> print("none of the above")
        }
    }

    fun is2(x: Int): Boolean {
        return (x % 2) == 0
    }

    /**
     * when  ----is or !is
     */
    fun hasPrefix(x: Any) = when (x) {
        is String -> x.startsWith("prefix")
        else -> false

    }

    /**
     * when
     * 如果不提供参数，所有的分支条件都是简单的布尔表达式，而当一个分支的条件为真时则执行该分支
     */
//    when {
//        x.isOdd() -> print("x is odd")
//        y.isEven() -> print("y is even")
//        else -> print("x+y is even.")
//    }

    /**
     * when
     * 自 Kotlin 1.3 起
     * 将 when 的主语（subject，译注：指 when 所判断的表达式）捕获到变量中
     */
//    fun Request.getBody() =
//        when (val response = executeRequest()) {
//            is Success -> response.body
//            is HttpError -> throw HttpException(response.status)
//        }

    /**
     * for
     */
    fun initFor() {
        val stringArray = arrayOf("a", "b", "c", "d")

        //普通使用
        for (item in stringArray) print(item)
        for (item: String in stringArray) {
            print(item)
        }

        //区间使用
        for (i in 1..10) {
            println(i)
        }
        for (i in 6 downTo 0 step 2) {
            println(i)
        }

        //索引的使用
        for (i in stringArray.indices) {
            println(stringArray[i])
        }

        //withIndex
        for ((index, value) in stringArray.withIndex()) {
            println("the element at $index is $value")
        }
    }
}