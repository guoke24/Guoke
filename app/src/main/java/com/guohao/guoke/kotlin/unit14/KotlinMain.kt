package com.guohao.guoke.kotlin.unit14

/**
 * 循环
 */
fun main(args:Array<String>){

    for(i in 1 ..10){ // 1 到 10
        println(i)
    }

    println("------")

    for(i in 1 until 10){ // 1 到 9
        println(i)
    }

    println("------")

    for(i in 10 downTo 1){ // 10 到 1 ，'..' 不能递减，递减要用 downTo
        println(i)
    }

    println("------")

    for( i in 1..10 step 2){ // 1 到 9，每次增幅为 2
        println(i)
    }

    println("------")

    repeat(10){// 1 到 9
        println(it) // it 是当前的计数器，可知循环到了第几次
    }


}