package com.guohao.guoke.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guohao.guoke.R

class OneActivity : AppCompatActivity() {

    companion object{
        val name = "companionObject"
        fun cry(){
            printlen("companionObject")
        }
    }

    object ObjectInner{
        var name: String = "Inner";
        fun lag(){
            printlen("ObjectInner")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        ObjectInner.lag()
        cry()
    }
}
