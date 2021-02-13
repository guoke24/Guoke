package com.guohao.guoke.kotlin.unit17

fun main(args:Array<String>){

    for(i in 1..100 step 2){ // '..' 对应的重载函数 public operator fun rangeTo(other: Int): IntRange
        println("$i")
    }

    // 等价于
    for (i in 1.rangeTo(100) step 2){
        println("$i")
    }

    // 运算符有限，只有120多个，所以有时候需要 'step' 这种中缀表达式来补充语义，step 也是一个函数
}