package com.elaine.mygzh.pagefour

/**
 * author: elaine
 * date: 2022/2/9
 */
class Student(
    _name: String,//临时变量使用下划线
    var age: Int,//直接定义变量的方式作为参数，更推荐这种方案
    var sex: Int = 1//默认参数，使用时不传入这个值则使用默认1
) {
    //只赋值一次
    var name = _name
        get() = field.lowercase()

    var hobbies: MutableList<String> = mutableListOf()

    //次构造函数
    constructor(name: String) : this(name, 18, 1) {
        this.name = name.trim()//定义初始化代码
    }

    //次构造函数
    constructor(name: String, age: Int) : this(name, age, 1)

    //此构造函数
    constructor(name: String, hobby: String) : this(name, 17, 1) {
        this.hobbies.add(hobby)
    }

    //初始化代码块
    init {
        //验证名字是否为空
        require(_name.isNotEmpty()) { print("name is empty") }
    }

    //延迟初始化变量，需要主动初始化
    lateinit var myClass: String

    //报名课程
    fun getClass() {
        myClass = "math"
    }

    //开始学习
    fun startLearn() {
        //判断课程是否初始化了，是则开始学习
        if (::myClass.isInitialized) print("开始学习《$myClass》")
    }

    //惰性初始化，当调用这个属性值的时候才去初始化
    val run by lazy {
        getReadyForRun()
    }

    private fun getReadyForRun(): String {
        print("我已经穿好运动鞋了")
        return "我可以跑了"
    }
}

fun test() {
    val student = Student("Elaine")
    print("name:" + student.name)
    print("age:" + student.age)

    student.getClass()
    student.startLearn()

    student.run//调用了才初始化

    //==，比较引用，类继承Any类，所以这里表的是引用
    //===，比较引用
    print(Student("小明") == Student("小明"))//false
    print(Student("小明") === Student("小明"))//false
}