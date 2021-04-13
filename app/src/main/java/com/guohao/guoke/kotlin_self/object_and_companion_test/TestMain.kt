package com.guohao.guoke.kotlin_self.object_and_companion_test

class TestMain {
    fun main(args: Array<String>){

        TestObject.name
        TestObject.cry()

        TestObject2.Inner.innerFun()
        TestObject2.Inner.name

        TestCompanion.sname
        TestCompanion.companionFun()
    }

}