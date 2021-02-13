package com.guohao.guoke.kotlin.kaixue

//声明一个成员变量并赋值
//class User(var name: String) {
//}
// 等价于：
//class User(name: String) {
//    var name: String = name
//}

//class User constructor(var name: String) {
//    // 直接调用主构造器
//    constructor(name: String, id: Int) : this(name) {
//    }
//    // 通过上一个次构造器，间接调用主构造器
//    constructor(name: String, id: Int, age: Int) : this(name, id) {
//    }
//    // 次级构造器，不能声明成员变量
//}

class User(val name: String, val id: String) {

    constructor(person: Person) : this(person.name, person.id) {
    }
    // 参数是先传到次级构造函数，再传给主构造函数滴
}

// ------ 构造器，结束 ------

