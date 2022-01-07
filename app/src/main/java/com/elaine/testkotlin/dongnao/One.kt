package com.elaine.testkotlin.dongnao

/**
 * author: elaine
 * date: 2021/11/9
 */
class One {

    var a = 1
    var b = a


    fun `110`() {
        println("110")
    }

    fun `thismethon`() {
        print("aaa")
    }

    /**
     * 函数引用
     */
    fun quote(): String {
        return "函数引用"
    }


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