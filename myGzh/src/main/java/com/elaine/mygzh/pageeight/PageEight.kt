package com.elaine.mygzh.pageeight

/**
 * author: elaine
 * date: 2022/3/2
 */
//跑腿业务
/**
 * 约束
 */
interface IHelpBuyer {
    //送达时间
    val time: Int

    /**
     * 帮忙买东西
     * product--商品
     */
    fun buyThing(product: String)

    /**
     * 传递东西
     * thing--东西
     * receiverName--签收者姓名
     */
    fun carryThing(thing: String, receiverName: String)
}

/**
 * 被委托对象
 * 美团小哥
 */
class MeiTuanXiaoGe(val name: String) : IHelpBuyer {
    override val time = 20
    override fun buyThing(product: String) {
        print("MeiTuan,$name need to buy the $product for the client in $time.")
    }

    override fun carryThing(thing: String, receiverName: String) {
        print("MeiTuan,$name need to carry the $thing for $receiverName in $time.")
    }

}

/**
 * 被委托对象
 * 饿了么小哥
 */
class EleMeXiaoGe(val name: String) : IHelpBuyer {
    override val time = 30
    override fun buyThing(product: String) {
        print("EleMe,$name need to buy the $product for the client in $time.")
    }

    override fun carryThing(thing: String, receiverName: String) {
        print("EleMe,$name need to carry the $thing for $receiverName in $time.")
    }

}

/**
 * 委托对象
 * 用户
 */
class User(val helpBuyer: IHelpBuyer) : IHelpBuyer by helpBuyer {
    override val time: Int
        get() = 60
    /**
     * 重写了传递东西的方法
     */
    override fun carryThing(thing: String, receiverName: String) {
        print("Me need to carry the $thing for $receiverName in $time.")
    }
}

/**
 * 使用
 */
fun testHelpBuyer() {
    //美团小哥Tony
    val meiTuanXiaoge1 = MeiTuanXiaoGe("Tony")
    //饿了么小哥Alice
    val eleMeXiaoGe1 = EleMeXiaoGe("Alice")
    //用户1需要买coffee
    val buyer1 = User(meiTuanXiaoge1)
    buyer1.buyThing("coffee")
    //用户2需要买fish
    val buyer2 = User(eleMeXiaoGe1)
    buyer2.buyThing("fish")

    //覆盖由委托实现的接口成员，则会执行委托对象里面的重写方法
    val buyer3 = User(meiTuanXiaoge1)
    buyer3.carryThing("gift", "Lily")
    //在委托者中重写的属性，不会被被委托者使用
    print(buyer3.time)

}





