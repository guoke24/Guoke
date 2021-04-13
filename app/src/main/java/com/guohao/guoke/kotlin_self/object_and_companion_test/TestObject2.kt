package com.guohao.guoke.kotlin_self.object_and_companion_test

/**
 * object 在类内部
 */
class TestObject2 {

    fun outFun(){
        print("")
        Inner.innerFun()
        Inner.name
    }

    object Inner{
        var name = "Inner"
        fun innerFun(){
            print("inner")
        }
    }

}