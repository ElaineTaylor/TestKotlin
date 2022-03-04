package com.elaine.mygzh.pagenine

/**
 * author: elaine
 * date: 2022/3/3
 */
//vararg 可传入多个参数
fun moreParameters(vararg parameter: Int) {
    print(parameter)
}

fun testMoreParameters() {
    moreParameters(1, 3, 4)
}