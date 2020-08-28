package com.elaine.testkotlin

import java.lang.IllegalArgumentException

/**
 * @author elaine
 * @date 2020/8/27
 */
class ThreeBasicType {
    /**
     * Int
     */
    val one = 1

    /**
     * 默认Long
     */
    val threeBillion = 3000000000

    /**
     * 指定为Long
     */
    val oneLong = 1L

    /**
     * 指定Byte
     */
    val oneByte: Byte = 1

    /**
     * Double
     */
    val pi = 3.14
    val e = 2.7182818284

    /**
     * Float
     * 实际值为 2.7182817
     */
    val eFloat = 2.7182818284f

    /**
     * 数字字面值中的下划线（自 1.1 起）
     * 使用下划线使数字常量更易读
     */
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    /**
     *  数字装箱不一定保留同一性
     *  ===(kotlin有，Java无) 三个等号的意思，则比较的是内存地址
     *
     *  java在编译Integer I = 100时（装箱），
     *  会翻译成Integer I = Integer.valueOf(100)。
     *  而java API中对Integer类型的valueOf的定义如下，
     *  对于-128到127之间的数，会进行缓存，
     *  Integer I=127时，会将127进行缓存，
     *  下次再写Integer j = 127时，
     *  就会直接存缓存中取，就不会new了。
     */
    fun initSame() {
        val a: Int = -129
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        val b: Int = 127
        val boxedB: Int? = b
        val anotherBoxedB: Int? = b

        val c: Int = 10000
        val boxedC: Int? = c
        val anotherBoxedC: Int? = c

        println(boxedA === anotherBoxedA) // false
        println(boxedB === anotherBoxedB) // true
        println(boxedC === anotherBoxedC) // false
    }

    /**
     * 相等性
     */
    fun initEqual() {
        val a: Int = 10000
        println(a == a) //true
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        println(boxedA == anotherBoxedA)//true
    }

    /**
     * 显示转换
     * 1.较小的类型不能隐式转换为较大的类型
     * toByte(): Byte
     * toShort(): Short
     * toInt(): Int
     * toLong(): Long
     * toFloat(): Float
     * toDouble(): Double
     * toChar(): Char
     */
    fun changeToAntherType() {
        val b: Byte = 1
        val i: Int = b.toInt() //显示转换
        print(i)
        val l = 1L + 3 // Long + Int => Long 可行，算术运算会有重载做适当转换
    }

    /**
     * 运算
     * 整数间的除法总是返回整数。会丢弃任何小数部分
     * 需返回浮点类型，请将其中的一个参数显式转换为浮点类型
     */
    fun initDivision() {
        val x = 5 / 2
        println(x == 2)//true
        val a = 5L / 2
        println(a == 2L)//true
        val b = 5 / 2.toDouble()
        println(b == 2.5)//true
    }


    /**
     * 位运算  TODO(未)
     *
     * 没有特殊字符来表示，而只可用中缀方式调用具名函数
     * shl(bits) – 有符号左移
     * shr(bits) – 有符号右移
     * ushr(bits) – 无符号右移
     * and(bits) – 位与
     * or(bits) – 位或
     * xor(bits) – 位异或
     * inv() – 位非
     */
    val x = (1 shl 2) and 0x000FF000

    /**
     * 浮点数比较 TODO（未）
     * 当这些操作数并非静态类型为浮点数（例如是 Any、 Comparable<……>、 类型参数）时，
     * 这些操作使用为 Float 与 Double 实现的不符合标准的 equals 与 compareTo，这会出现：
     * 认为 NaN 与其自身相等
     * 认为 NaN 比包括正无穷大（POSITIVE_INFINITY）在内的任何其他元素都大
     * 认为 -0.0 小于 0.0
     */

    /**
     * 字符
     * 字符用 Char 类型表示。它们不能直接当作数字
     * 字符字面值用单引号括起来: '1'
     * 当需要可空引用时，像数字、字符会被装箱。装箱操作不会保留同一性。
     */
    fun decimalDigitValue(c: Char): Int {
        if (c !in '0'..'9')
            throw IllegalArgumentException("Out of range")
        return c.toInt() - '0'.toInt()
    }

    /**
     * 数组
     * 属于Array类
     * 库函数arrayOf()
     * 库函数arrayOfNulls()，用于创建一个指定大小的，所有元素都为空的数组
     */
    fun initArray() {
        val asc = Array(5) { i -> (i * i).toString() }
        asc.forEach { println(it) }
    }

    /**
     * 原生类型数组
     * 属于无装箱开销的专门的类
     */
    fun initUnitArray() {
        val arr = IntArray(5) //[0, 0, 0, 0, 0]
        val arrOne = IntArray(5) { 42 } //[42, 42, 42, 42, 42]
        val arrTwo = IntArray(5) { it * 1 } //[0, 1, 2, 3, 4]
    }

    /**
     * 无符号整形 TODO（未）
     *
     * kotlin.UByte: 无符号 8 比特整数，范围是 0 到 255
     * kotlin.UShort: 无符号 16 比特整数，范围是 0 到 65535
     * kotlin.UInt: 无符号 32 比特整数，范围是 0 到 2^32 - 1
     * kotlin.ULong: 无符号 64 比特整数，范围是 0 到 2^64 - 1
     *
     * 特殊的类
     * kotlin.UByteArray: 无符号字节数组
     * kotlin.UShortArray: 无符号短整型数组
     * kotlin.UIntArray: 无符号整型数组
     * kotlin.ULongArray: 无符号长整型数组
     */


    /**
     * 字面值 TODO（未）
     *
     */
    val b: UByte = 1u
    val s: UShort = 1u
    val l: ULong = 1u
    val a1 = 42u //UInt
    val a2 = 0xFFFF_FFFF_FFFFu //ULong
    val a = 1UL//ULong

    /**
     * 字符串
     * 在大多数情况下，优先使用字符串模板或原始字符串而不是字符串连接(+)
     */

    /**
     * 字符串字面值
     */
    fun initString() {
        val s = "Hello,world!\n"  //转义字符串可以有转义字符

        //原始字符串 使用三个引号（"""）分界符括起来，内部没有转义并且可以包含换行以及任何其他字符
        val text = """
                for (c in "foo")
                print(c)
        """.trimMargin()

        val text1 = """
            |Tell me and I forget.
            |Teach me and I remember.
            |Involve me and I learn.
            |(Benjamin Franklin)
            """.trimMargin()
    }

    /**
     * 字符串模板
     * 美元符（$）开头，由一个简单的名字构成
     */
    fun initStringDemo() {
        val i = 10
        println("i=$i") //“i = 10”

        val s = "abc"
        println("$s.length is ${s.length}") //模板表达式 “abc.length is 3”

        //在原始字符串中表示字面值 $ 字符
        val price = """
            ${'$'}9.99
        """.trimIndent()
    }

}