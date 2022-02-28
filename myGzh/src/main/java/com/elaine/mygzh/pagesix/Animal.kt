package com.elaine.mygzh.pagesix

/**
 * 约束条件
 * author: elaine
 * date: 2022/2/17
 */
//父类
open class Animal(var foot: Int)

//鸭子，继承Animal
class Duck(var eat: String) : Animal(foot = 2)

//兔子，继承Animal
class Rabbit(var eat: String) : Animal(foot = 4)

open class Furniture(var type: String)

//桌子，没有继承Animal
class Desk(var size: Int) : Furniture("桌子")

//T类型的约束条件是Animal
fun <T : Animal> showAnimalFoot(param: T) {
    print(param.foot)
}

fun testAnimal() {
    showAnimalFoot(Duck("米"))
    showAnimalFoot(Rabbit("胡萝卜"))
    //showAnimal(Desk(2))//报错，原因是Desk不属于Animal
}

//多个约束条件
fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}

//fun <T> showFamilyHas(param: T): T
//        where T : Furniture,
//              T : Animal {
//    return param
//}