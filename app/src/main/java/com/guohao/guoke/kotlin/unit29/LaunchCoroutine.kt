package com.guohao.guoke.kotlin.unit29

import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import okhttp3.*

private val mOkHttpClient = OkHttpClient()
private val mRequest = Request.Builder().url("https://baidu.com").get().build()

fun displayDashboard(textView: TextView) = runBlocking {
    launch {

        val job2 = async(AndroidCommonPool) {
            // 所在线程：AsyncTask #1
            Log.e("guohao","async 1 - thread name: " + Thread.currentThread().name)
            withContext(Dispatchers.IO){
                // 所在线程：DefaultDispatcher-worker-1
                Log.e("guohao","async 2 - thread name: " + Thread.currentThread().name)
                mOkHttpClient.newCall(mRequest).execute().body()?.string()
            }
        }
        textView.text = job2.await()

        // ------ 分割线 ------

//        val deferred = async(AndroidCommonPool) {
//            // 因为指定了线程池，所以所在的线程类似：AsyncTask #1
//            Log.e("guohao","async 3 - thread name: " + Thread.currentThread().name)
//            //不考虑异常的情况
//            mOkHttpClient.newCall(mRequest).execute().body()?.string()
//        }
//        // 这里虽然没调用 suspend 函数，但指定了线程池，所以也是异步执行？
//
//        textView.text = deferred.await()

    }
}
