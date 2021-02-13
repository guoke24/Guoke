package com.guohao.guoke.kotlin.unit17

// 密闭类，有三个结果
sealed class CompareResult{
    object LESS : CompareResult(){
        override fun toString(): String {
            return "小于"
        }
    }
    object EQUAL : CompareResult(){
        override fun toString(): String {
            return "等于"
        }
    }
    object MORE: CompareResult(){
        override fun toString(): String {
            return "大于"
        }
    }
}

// 定义一个中缀表达式，Int 是函数 vs 的接收者
// 所谓中缀表达式，就像 5 vs 6，vs 在中间，其可以像函数那样去调用： 5.vs(6)
infix fun Int.vs(num: Int) : CompareResult =
    if(this - num > 0){
        CompareResult.MORE
    }else if(this - num < 0){
        CompareResult.LESS
    }else{
        CompareResult.EQUAL
    }

fun main(args: Array<String>){
    println(5 vs 6)
}