package com.guohao.guoke.kotlin.unit29

import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun displayDashboard2(textView: TextView) = runBlocking{
    Log.e("guohao","runBlocking thread ${Thread.currentThread().name}")
    // launch(Dispatchers.Main) 这样会死锁的效果哟，参考这个：https://tieba.baidu.com/p/6435817585 ，参考参考，说得不是很清楚。。。
    // launch 本身是不阻塞当前线程的，但是 runBlocking 会阻塞当前线程；所以，
    // 当 runBlocking 执行的时候，就会阻塞指定运行在当前线程（即主线程）的 launch(Dispatchers.Main)
    launch {
        Log.e("guohao","launch thread ${Thread.currentThread().name}")
        val job = async(AndroidCommonPool) {
            Log.e("guohao","async thread ${Thread.currentThread().name}")
            return@async "async"
        }
        Log.e("guohao","job ${job.await()} thread ${Thread.currentThread().name}")
    }
}


