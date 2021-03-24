package com.guohao.guoke.kotlin.kaixue.staticreplace

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