package com.elaine.mygzh.pagefive

import android.view.View

/**
 * author: elaine
 * date: 2022/2/16
 */
//封闭类
sealed class MyDialogOpera {
    object Show : MyDialogOpera()
    object Hide : MyDialogOpera()
    class TranslateX(val x: Float) : MyDialogOpera()
}

fun execute(view: View, opera: MyDialogOpera) = when (opera) {
    MyDialogOpera.Show -> view.visibility = View.VISIBLE
    MyDialogOpera.Hide -> view.visibility = View.GONE
    is MyDialogOpera.TranslateX -> view.translationX = opera.x
}
