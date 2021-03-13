package com.guohao.guoke.kotlin.kaixue

/**
 *
 */
class Person(val name: String, val id: String) {

    protected var pName: String? = null

    fun cry(word:String){
        println(word)
    }

    inner class cat{

        fun laugh(){
            cry("hello")
            println(pName)
        }

    }

}