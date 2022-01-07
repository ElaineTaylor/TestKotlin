package com.elaine.mygzh.pagethree

import android.os.Build

/**
 * author: elaine
 * date: 2022/1/6
 */

val array1 = arrayOf("one", "two", "three")
val array2 = arrayOf(1, 2, 3, 4, 5, 6)
val booleanArray = booleanArrayOf(true, false)
val intArray = intArrayOf(1, 2, 3)
val floatArray = floatArrayOf(1.1f, 2.2f, 3.3f)
val doubleArray = doubleArrayOf(1.1, 2.2, 3.3)
val byteArray = byteArrayOf(1, 2, 3)
val charArray = charArrayOf('a', 'b', 'c')
val longArray = longArrayOf(1000L, 200L, 300000L)
val shortArray = shortArrayOf(1, 2, 3)

/**
 * array的相关方法
 */
fun testArray() {
    array1[0]//获取值
    array2.all { it > 4 }//判断数组是否都是大于4的值
    array2.any { it > 2 }//判断数组里是否有大于2的值
    array2.find { it == 2 } //判断是否有值等于2
}


/**
 * list（只读列表）
 * mutableList，arrayList（可变列表）
 */
val list1 = listOf("one", "two", "three")
val list2 = listOf(1, 2, 3)
val list3 = listOf(1.1, 2.2, 3.3)
val list4 = listOfNotNull(1, "aa", 1.1, null) //自动去除null
val mutableList5 = mutableListOf("one", "two", "three")
val mutableList6 = mutableListOf(1, 2, 3)
val mutableList7 = mutableListOf(1.1, 2.2, 3.3)
val mutableList8 = mutableListOf(1, "2", 3.3, null)//null占坑位
val arrayList1 = arrayListOf("one", "two", "three")
val arrayList2 = arrayListOf(1, 2, 3)

/**
 * list相关方法
 */
fun testList() {
    list1.toMutableList()//list转mutableList
    mutableList5.toList()//mutableList转list
    mutableList6.removeAt(1)//移除位置1的数据
    mutableList6.remove(2)//移除数据为2的数据
    mutableList6.add(5)//添加元素5
    mutableList6[0] = 3//更改位置为0的元素值
    mutableList6 += 7//添加元素7
    mutableList6 -= 7//删除元素7
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        mutableList5.removeIf { it.contains("o") }//根据lambda的判断来删除元素
    }
    print(list1.getOrElse(4) { "four not exit" })//空安全索引取值函数，若为空则输出lambda表达式的值
    print(list1.getOrNull(5))//空安全索引取值函数，若为空则输出null
    list1.forEach { print(it) }//遍历
    mutableList6.forEachIndexed { index, value -> //遍历
        print("$index,$value")
    }
    val (_, two, three) = list2//解构，下划线表示这个元素不需要取出来
    print("$two,$three")
    mutableList7.clear()//清空列表
    list3.subList(1, 2)//获取子集合
    list4.distinct()//元素去重
    mutableList6.fill(4)//将所有集合元素的值替换为指定值。
    mutableList6.removeFirst()//删除第一个字母
    mutableList6.removeLast()//删除最后一个字母
}

/**
 * set(不重复元素)
 * setOf---只读
 * hashSet，linkedSet，mutableSet，sortedSet---可变
 */
val set1 = setOf("one", "two", "three")//只读set
val set2 = setOf(1, 2, 3)//只读set
val set3 = setOfNotNull("a", "b", null)//自动去除null
val hashSet = hashSetOf("one", "two", "three")//带hash值的set
val linkedSet = linkedSetOf("one", "two", "three")//有顺序的可变set
val mutableSet = mutableSetOf("one", "two", "three")//可变set
val sortedSet = sortedSetOf("one", "two", "three")//树形结构set

/**
 * set的相关方法
 */
fun testSet() {
    set1.toMutableSet()//转换为mutableSet
    print(set1.elementAt(1))//打印位置为1的元素
    mutableSet += "four"//添加元素
    mutableSet -= "one"//删除元素
    mutableSet.remove("one")//删除元素
    hashSet.add("four")//添加元素
    set1 union set3//并集
    set1 intersect set2 //交集
    set1 subtract set3//差集
}

/**
 * 健值对存储
 * mapOf---只读
 * mutableMapOf，hashMapOf，linkedMapOf，sortedMapOf---可变
 */
val map1 = mapOf("one" to 1, "two" to 2, "three" to 3)//to关键字
val map2 = mapOf(Pair("one", 1), Pair("two", 2), Pair("three", 3))//Pair关键字
val mutableMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3)//可变map
val hashMap = hashMapOf("one" to 1, "two" to 2, "three" to 3)
val linkedMap = linkedMapOf("one" to 1, "two" to 2, "three" to 3)
val sortedMap = sortedMapOf("one" to 1, "two" to 2, "three" to 3)

/**
 * map的相关方法
 */
fun testMap() {
    print(map1.getValue("one"))//获取值
    print(map1.getOrElse("four") { "No exit" })//获取值，若为空则返回lambda的内容
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        print(map1.getOrDefault("four", 0))//获取值，若为空则返回默认值
    }
    map1.forEach {
        print("${it.key} ,${it.value}")//遍历元素
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        map1.forEach { (t: String, u: Int) -> print("$t,$u") }//遍历元素
    }
    mutableMap.getOrPut("one") { 2 }//存在直接返回结果
    mutableMap.getOrPut("four") { 4 }//若不存在，则直接添加并返回

    map1.toMutableMap()//转换为MutableMap
    mutableMap.toMap()//转换为map

    map1.filterKeys { it.contains("o") }//根据key过滤
    map1.filterValues { it < 0 }//根据value过滤
}
