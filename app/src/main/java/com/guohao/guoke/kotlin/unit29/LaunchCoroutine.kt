package com.guohao.guoke.kotlin.unit29

import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import okhttp3.*

private val mOkHttpClient = OkHttpClient()
private val mRequest = Request.Builder().url("https://baidu.com").get().build()

fun displayDashboard(textView: TextView) = runBlocking {
    launch {

//        val job2 = async(AndroidCommonPool) {
//            withContext(Dispatchers.IO){
//                mOkHttpClient.newCall(mRequest).execute().body()?.string()
//            }
//        }
//        textView.text = job2.await()

        // ------ 分割线 ------

        // 这个是有效写法
        val deferred = async(AndroidCommonPool) {
            //不考虑异常的情况
            mOkHttpClient.newCall(mRequest).execute().body()?.string()
        }
        // 这里虽然没调用 suspend 函数，但指定了线程池，所以也是异步执行？

        textView.text = deferred.await()

    }
}
