package com.guohao.guoke.kotlin_self.object_and_companion_test

class TestCompanion {

    var name = "string"
    fun outFun(){
        sname
        companionFun();
    }

    companion object {
        var sname = "companion"
        //@JvmStatic
        fun companionFun(){
            print("com")
        }
    }

}