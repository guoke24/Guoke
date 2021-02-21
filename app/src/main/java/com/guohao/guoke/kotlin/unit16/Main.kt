package com.guohao.guoke.kotlin.unit16

data class User(var name: String)

/**
 * 作用域函数
 */
fun main(args: Array<String>){

    val user = User("guohao")
    // let 和 run 函数都会返回闭包的执行结果，let 有闭包参数，run 没有
    val letResult = user.let { user: User -> "let::${user.javaClass}"  }
    val runResult = user.run { "run::${this.javaClass}" }
    println(letResult)
    println(runResult)

    // also 和 apply 函数都不会返回闭包的执行结果，also 有闭包参数，apply 没有
    user.also { println("also::${it.javaClass}") }
    user.apply { println("apply::${this.javaClass}") }

    // also 函数还会返回自身，所以可以调用
    user.also { println("alse") }.apply { println("apply") }

    // takeIf 当闭包结果为 true，返回自己，否则返回空
    // takeUnless 跟 takeIf 相反
    user.takeIf { it.name.length > 0 }?.also { println("姓名不为空") }?: println("姓名为空")
    user.takeUnless { it.name.length > 0 }?.also { println("姓名为空") }?: println("姓名不为空")

    // repeat 也是作用域函数
    repeat(5){
        println(it)
    }

    // 上述的作用域函数，都是某个对象的拓展函数
    // with 则是顶层函数，不以拓展方法的形式出现
    with(user){
        this.name = "with"
    }

    // 等价于 user.apply { this.name = "with" }
    // 但 with 这种学法，可以对多个 User 实例进行相同对赋值操作，但只需写一次闭包

    // 作用域函数，集合的操作符，还有很多哦
}