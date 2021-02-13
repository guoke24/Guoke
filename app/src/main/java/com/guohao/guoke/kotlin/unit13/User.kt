package com.guohao.guoke.kotlin.unit13

class User(var age: Int, var name: String) {
    operator fun component1() = age
    operator fun component2() = name
    // operator 将一个函数，重载为一个操作符，或者实现一个约定
}