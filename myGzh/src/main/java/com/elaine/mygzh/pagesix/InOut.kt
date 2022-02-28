package com.elaine.mygzh.pagesix

/**
 * author: elaine
 * date: 2022/2/28
 */
//生产者
interface Production<out T> {
    fun product(): T
}

//消费者
interface Consumer<in T> {
    fun consume(item: T)
}

open class Food
open class FastFood : Food()
class Burger : FastFood()

class FoodStore : Production<Food> {
    override fun product(): Food {
        return Food()
    }
}

class FastFoodStore : Production<FastFood> {
    override fun product(): FastFood {
        return FastFood()
    }
}

class BurgerStore : Production<Burger> {
    override fun product(): Burger {
        return Burger()
    }
}

class Everyone : Consumer<Food> {
    override fun consume(item: Food) {
        print("eat food")
    }
}

class ModernPeople : Consumer<FastFood> {
    override fun consume(item: FastFood) {
        print("eat FastFood")
    }
}

class American : Consumer<Burger> {
    override fun consume(item: Burger) {
        print("eat Burger")
    }
}


fun testInOut() {
    //子类泛型对象可以赋值给父类泛型对象，用out
    val prduction1: Production<Food> = FoodStore()
    val prduction2: Production<Food> = FastFoodStore()
    val prduction3: Production<Food> = BurgerStore()
    //父类泛型对象可以赋值给子类泛型对象，用in
    val consumer1: Consumer<Food> = Everyone()
    val consumer2: Consumer<FastFood> = ModernPeople()
    val consumer3: Consumer<Burger> = American()
}



