package com.guohao.guoke.kotlin.unit15

/**
 * 集合的操作符
 */
fun main(args:Array<String>){
    val a = arrayOf("4","0","7","i","f","w","0","9")
    val index = arrayOf(5,3,9,4,8,3,1,2,1,7)

    // 这一段用 RxJava 写会很复杂
    index
        .filter {  // 过滤函数
            it < a.size
        }
        .map {     // 映射函数
            a[it]
        }
        .reduce {  // reduce函数：累加函数，第一个参数是用来叠加的返回值，第二个参数是本次循环中列表的值
            s,s1 -> "$s$s1"
        }
        .also {
            println("密码是：$it")
        }

    myOperator()
}

fun myOperator(){
    val list = listOf<Int>(1,2,3,4)
    list.convert{
        it + 1
    }.forEach{
        print(it)
    }
}

/**
 * 内联函数，重载操作符
 * 该函数接收一个 action 闭包，该闭包接收一个 T 类型参数，返回一个 E 类型参数
 * 该函数返回一个 MutableList<E>
 */
inline fun<T,E> Iterable<T>.convert(action:(T) -> E): MutableList<E>{
    val list = mutableListOf<E>()
    for( item:T in this) list.add(action(item)) // this 指的是 Iterable 本身，即调用 convert 的对象
    return list
}