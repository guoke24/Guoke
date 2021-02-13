package com.guohao.guoke.kotlin

var age : Int = 18;
val name : String = "guohao" // val 不可变

var age1 = 18   // 可推断，不写类型
var name1 = "guohao"

// 空安全，上述变量不可为空
// ？表示可以空
// String 和 String? 不可赋值
var name3 : String? = null

fun main(args : Array<String>){
    //name1 = name3!! // 强转
    name3 = name1   // 反之不用强转
    printlen(name)
}

fun printlen(str : String) : String{

    print("这个字符串是： $str") // $ 在""内引用字符串变量，这叫模版语法

    return str
}

object Object1{
    var name = "guohao";
    fun cry(){
        printlen("I am Object1 ")
    }

}