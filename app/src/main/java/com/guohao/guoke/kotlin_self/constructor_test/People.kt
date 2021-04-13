package com.guohao.guoke.kotlin_self.constructor_test

/**
 * 主构造函数
 * 1，constructor 可以省略
 * 2，加上 var，就是声明成员属性，且带上 getter/setter
 * 3，可以有默认值
 * 4，次级构造函数，必须调用主构造函数
 * 5，init 代码块中，执行主构造函数的初始化逻辑
 */
class People constructor(var name:String,var age:Int = 1) {

    init {
        println("I am $name") // 字符串模版
    }

    /**
     * 次级构造函数，必须调用主构造函数
     */
    constructor(name: String, nickname: String) : this(name) // 默认值不用传参数


    // 这样写会冲突：Platform declaration clash:
    // The following declarations have the same JVM signature (setName(Ljava/lang/String;)V):
//    fun setName(value: String){
//        this.name = value
//    }
    // 如果想拓展成员属性 name 的 setter/getter，怎么做
    // 声明不要写在主构造函数中


}