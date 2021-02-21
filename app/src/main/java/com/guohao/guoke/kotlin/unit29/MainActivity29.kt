package com.guohao.guoke.kotlin.unit29

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.guohao.guoke.R
import kotlinx.android.synthetic.main.activity_main29.*
import okhttp3.*
import java.io.IOException

/**
 * 语法糖
 */
class MainActivity29 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main29)
    }

    fun test1(v: View){
        mContent.text = null
    }

    fun test2(v: View){
        Dashboard().display(mContent)
    }

    fun test3(v: View){
        //displayDashboard2(mContent)
        displayDashboard(mContent)
    }
}