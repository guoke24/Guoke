package com.guohao.guoke.kotlin.kaixue

fun main(args : Array<String>){
    // 细节一：
    // ::b 是个对象，一个函数类型的对象；
    // 其内部的 invoke 函数复制了函数 b 的功能；
    a(::b)
    val c = ::b
    c.invoke(1) // 等价于 b(1)

    // 细节二，函数对象的引用，不用再加"::"
    val e = c

    // 细节三，匿名函数作为参数，此时不允许有函数名
    a(fun(param:Int):String{
        return param.toString()
    })

    // 细节四， 匿名函数作为函数对象，，此时也不允许有函数名
    val d = fun(param: Int): String {
        return param.toString()
    }
}

// 细节一：函数作为参数，函数类型这么表示：(Int) -> String
fun a(fun1: (Int) -> String){
    print("执行fun1前")
    fun1(1)
    print("执行fun1后")

}

fun b(param:Int):String{
    return "num is ${param}"
}