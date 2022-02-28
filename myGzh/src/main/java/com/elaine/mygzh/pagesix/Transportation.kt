package com.elaine.mygzh.pagesix

/**
 * author: elaine
 * date: 2022/2/28
 */
open class Transportation(val energy: String)

class ElectricityCar(val name: String) : Transportation("电")

class OilCar(val name: String) : Transportation("油")

class TransportationFactory {
    //根据传入的类型推导出T的类型，从而可以进行T的判断
    inline fun <reified T> getTransportation(transportation: () -> T): T {
        val list = listOf(ElectricityCar("比亚迪"), OilCar("奔驰"))
        val random = list.shuffled().first()
        return if (random is T) {
            random
        } else {
            transportation()
        }
    }
}

fun testTransportationFactory() {
    val factory = TransportationFactory()
    //此处的result类型为OilCar
    val result = factory.getTransportation {
        OilCar("宝马")
    }
    //此处的result类型为ElectricityCar
    val result2 = factory.getTransportation {
        ElectricityCar("宝马")
    }
}