package com.elaine.testkotlin

/**
 * @author elaine
 * @date 2020/8/28
 */
class SixBreakAndReturn {

    /**
     * Nothing类型 （未）
     */
//    val s = person.name ?: return

    /**
     * Break 与 Continue 标签
     * 标签限制的 break 跳转到刚好位于该标签指定的循环后面的执行点。
     * continue 继续标签指定的循环的下一次迭代。
     */
    fun initLabel() {
        loop@ for (i in 1..100) {
            if (i == 50) break@loop
            if (i == 25) continue@loop
        }
    }

    /**
     * 返回到标签
     */
    fun foo() {

        //12
        listOf(1, 2, 3, 4, 5).forEach { if (it == 3) return print(it) }
        println("this point is unreachable")

        //1245 done with explicit label
        listOf(1, 2, 3, 4, 5).forEach lit@{
            if (it == 3) return@lit  // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
            print(it)
        }
        print("done with explicit label")

        //1245 done with implicit label
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@forEach // 隐式标签
            print(it)
        }
        print("done with implicit label")

        //1245 done with anonymous function
        listOf(1, 2, 3, 4, 5).forEach {
            fun(value: Int) {
                if (value == 3) return //部返回到匿名函数的调用者，即 forEach 循环
                print(value)
            }
            print(" done with anonymous function")
        }

        //12 done with nested loop
        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@loop
                print(it)
            }
            print("done with nested loop")
        }

        //return@a 1 意为“返回 1 到 @a”，而不是“返回一个标签标注的表达式 (@a 1)”
    }

}