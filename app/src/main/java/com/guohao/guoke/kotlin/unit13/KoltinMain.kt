package com.guohao.guoke.kotlin.unit13

/**
 * 解构
 */
fun main(args:Array<String>){
    val user = User(12,"name")
    val (age, name) = user // 解构
    println(age)
    println(name)

    // 这里是解构更常用的示例
    val map = mapOf<String,String>("key1" to "value1","key2" to "value2")
    for((k : String,v : String) in map) // 解构
    {
        println("$k--$v")
    }
}