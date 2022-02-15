package com.elaine.mygzh.pagefive

/**
 * author: elaine
 * date: 2022/2/14
 */
class Place(val x: Int, val y: Int) {

}

enum class Direction(private val inPlace: Place) {
    EAST(Place(1, 0)),
    SOUTH(Place(0, 1)),
    NORTH(Place(0, -1)),
    WEST(Place(-1, 0));

    //定义函数
    fun updateDirection(place: Place) = Place(inPlace.x + place.x, inPlace.y + place.y)
}

fun testDirection() {
    print(Direction.EAST.updateDirection(Place(100, 100)))

    print(Direction.EAST.ordinal)//0
    print(Direction.EAST.name)//EAST

    print(Direction.EAST)

    //values() 遍历
    Direction.values().forEach {
        //名字
        print(it.name)
        //顺序
        print(it.ordinal)
    }

    //valueOf() 若没有找到，则抛出 IllegalArgumentException 异常。
    print(Direction.valueOf("EAST"))
}

//枚举类
enum class Class {
    MATH,
    ENGLISH,
    CHINESE;
}


//代数数据类型ADT
fun testClass(className: Class): String {
    return when (className) {
        Class.MATH -> "数学"
        Class.ENGLISH -> "英语"
        Class.CHINESE -> "中文"
    }
}

//匿名枚举类
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}