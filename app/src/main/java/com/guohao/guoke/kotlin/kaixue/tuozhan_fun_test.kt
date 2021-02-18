package com.guohao.guoke.kotlin.kaixue

import android.content.res.Resources
import android.util.TypedValue

class tuozhan_fun_test {

    fun main(array: Array<String>){

        var p = Person("zhangsan","123")
        // 细节一：用 "::" 来引用成员函数
        (Person::cry)(p,"hello")// 实际是调用了参数1的对象的函数
        (Person::cry).invoke(p,"hello")

        // 细节四，拓展函数可以引用吗？
        // 可以，跟成员函数一样，Recever::fun 的方式
        (String::method1)("hello",1)
        (String::method1).invoke("hello",1)

        // 细节六
        // 拓展函数的赋值
        var a = Person::cry     // 省略类型的成员函数的引用赋值
        var b = String::method1 // 省略类型的拓展函数的引用赋值
        val a1 : Person.(String) -> Unit = Person::cry   // 带类型的成员函数的引用赋值
        var b1 : (String, Int) -> Unit = String::method1 // 带类型的拓展函数的引用赋值
        // 函数对象再给别的变量赋值
        val c = a1
        val d = b1

        // method3 是一个普通的函数
        val e: (String, Int) -> Unit = ::method3
        // 细节七：普通函数，也能够赋值给拓展函数类型的对象！
        val f: String.(Int) -> Unit = ::method3

        // 反向操作
        val g: String.(Int) -> Unit =  String::method4
        // 细节八：拓展函数，也能够赋值给普通函数的对象
        val h:(String, Int) -> Unit =  String::method4


        // 扩展属性的用法
        val RADIUS = 200f.dp
        println("RADIUS = ${RADIUS}")
    }

    // 细节二：
    // 写在类里面的String类的拓展函数，同时也是一个成员函数，在外面不能被调用；
    // 为什么要把扩展函数写在类的里面？不就是为了让它不要被外界看见造成污染吗，是吧？
    fun String.method2(i: Int) {
        //...
    }
    // 细节五：既是成员函数又是拓展函数的函数，能被引用？
    // 用谁的类名？是这个函数所属的类名，还是它的 Receiver 的类名？这是有歧义的，所以 Kotlin 就干脆不许我们引用既是成员函数又是扩展函数的函数了，一了百了。

    // 细节九，扩展属性
    val Float.dp
        get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this,
            Resources.getSystem().displayMetrics
        )

}

// String类的拓展函数
fun String.method1(i:Int){
    print("i = ${i}")
}
// 细节三：
//这个函数属于谁？
//它是个 Top-level Function，它谁也不属于，或者说它只属于它所在的 package。

fun method3(s: String, i: Int) {

}

fun String.method4(i: Int) {

}

