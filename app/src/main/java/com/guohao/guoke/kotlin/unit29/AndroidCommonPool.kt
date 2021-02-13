package com.guohao.guoke.kotlin.unit29

import android.os.AsyncTask
import kotlinx.coroutines.CoroutineDispatcher
import kotlin.coroutines.CoroutineContext

object AndroidCommonPool : CoroutineDispatcher() {

    override fun dispatch(context: CoroutineContext, block: Runnable) {

        AsyncTask.THREAD_POOL_EXECUTOR.execute(block)
    }
}