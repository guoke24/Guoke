package com.guohao.guoke.kotlin_self

import kotlin.reflect.KProperty

class Outer {

    // 成员属性被编译成静态的
    // 成员函数还是动态的，外部类也会声明一个静态函数引用该类的成员函数
    // 生成一个静态的字段 Companion 引用本类的实例
    companion object{
        var cache : String? = null
    }

    fun test1(){
        token = "hello"
    }

    var token : String? by Saver("token")

    // 被编译成静态内部类
    class Saver(var token:String){
        operator fun getValue(out:Outer,property:KProperty<*>): String? {
            return cache
        }
        operator fun setValue(out:Outer,property:KProperty<*>, value: String?){
            cache = value
        }
    }
}