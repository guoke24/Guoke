package com.guohao.guoke.kotlin.unit27

import kotlinx.coroutines.*

/**
 * 开启协程的三种常用方式：
 * runBlocking 线程切换到协程的过渡，指开启外层循环
 * launch 最常用的方式
 * async/await 一起使用，通过 Deferred 拿到结果，会阻塞
 */
fun main(args:Array<String>) = runBlocking<Unit>{ // runBlocking 会启动最外层的协程

    var time = -1

    val job = launch {
        repeat(500){
            println("挂起中 $it ... 过了 ${(++time)*500} 毫秒" )
            delay(500)

        }
    }

    val job2: Deferred<String> = async {
        delay(500)
        return@async "hello"
    }

    println("job2的输出：" + job2.await()) // 主线程会等到 job2 执行结束返回后，才开始执行

    delay(1300)
    println("main::主线程等待中")
    job.cancel()
    job.join()
    println("main::即将完成退出")

}