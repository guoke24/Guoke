package com.guohao.guoke.kotlin.unit29

import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*

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


// testCoroutine1 和 testCoroutine2 是两种使用协程进行异步操作的常见套路


fun testCoroutine1(){

    Log.e("guohao","-->testCoroutine1，thread： " + Thread.currentThread().name)
    Log.e("guohao","begin launch")

    GlobalScope.launch{
        Log.e("guohao","-->launch，thread： " + Thread.currentThread().name)
        Log.e("guohao","-->launch，开始请求 ")
        val beginTime = System.currentTimeMillis()
        val res1 = loadData1()    // 挂起点1
        val res2 = computeData2() // 挂起点2
        Log.e("guohao","结果为：${res1}、${res2}")
        val endTime = System.currentTimeMillis()
        Log.e("guohao","耗时：" + ((endTime - beginTime)/1000) + "秒"  )
    }
    Log.e("guohao","after launch")
}

// 如果希望 loadData1() 和 computeData2() 同时执行，再同时等待结果，可以开子协程
fun testCoroutine2(){
    GlobalScope.launch{
        Log.e("guohao","-->launch")
        val beginTime = System.currentTimeMillis()
        var res1 = GlobalScope.async {
            loadData1()
        }
        var res2 = GlobalScope.async {
            computeData2()
        }
        Log.e("guohao","结果为：${res1.await()}、${res2.await()}")
        val endTime = System.currentTimeMillis()
        Log.e("guohao","耗时：" + ((endTime - beginTime)/1000) + "秒"  )
    }
}


// suspend 表明这是挂起函数
// suspend 只是提醒这是一个耗时函数
// withContext 指定了要在那个线程运行
private suspend fun loadData1():Int{
    // 在 suspend 函数中，才能调用 withContext
    return withContext(Dispatchers.IO){ // IO操作
        Log.e("guohao","-->loadData1，thread： " + Thread.currentThread().name)
        delay(3000) // 耗时 1s
        1 // 返回值
    }
}

private suspend fun computeData2():String{
    return withContext(Dispatchers.Default){ // 计算操作，适合 CPU 密集型的任务
        Log.e("guohao","-->loadData2，thread： " + Thread.currentThread().name)
        delay(1000) // 耗时 1s
        "data2" // 返回值
    }
}