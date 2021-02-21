package com.guohao.guoke.jetpack

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MyViewModel : ViewModel() {

    private var name: MutableLiveData<String>? = null

    fun getName(): LiveData<String> {
        if (name == null) {
            name = MutableLiveData()
            addName()
        }
        return name as MutableLiveData<String>
    }
//    对应 java 代码：
//    public LiveData<String> getName() {
//        if (name == null) {
//            name = new MutableLiveData<String>();
//            addName();
//        }
//        return name;
//    }

    private fun addName() {
        // '!!'，即不做空检查，直接给 name 设置值
        name!!.value = "Android进阶解密"
    }
//    对应 java 代码：
//    private void addName() {
//        name.setValue("Android进阶解密");
//    }

    // 耗时操作
    fun loadData(){
        // 协程
        runBlocking{
            Log.e("guohao","runBlocking - thread name: " + Thread.currentThread().name)
            Log.e("guohao","before launch")

            // 我要新建一个协程，并在指定的线程运行它
            launch {
                Log.e("guohao","launch1 - thread name: " + Thread.currentThread().name)
                // 主线程中，也能延时操作
                //delay(2000)
                //(getName() as MutableLiveData<String>).postValue("form launch 1")// todo 这个为何收不到。。。时间久的那个能收到

                // withContext 是 suspend 函数
                val res = withContext(Dispatchers.IO){
                    Log.e("guohao","launch1 - withContext1 - thread name: " + Thread.currentThread().name)
                    delay(2000)
                    Log.e("guohao","launch1 - withContext1 - delay finish ")
                    (getName() as MutableLiveData<String>).postValue("form launch 1 withContext 1")
                    "from withContext"
                }
                // 这句话，会等到 res 有结果才返回
                Log.e("guohao","launch1 - thread name: " + Thread.currentThread().name + "我又切回来了：${res}")

            }

            launch(Dispatchers.IO) {
                Log.e("guohao","launch2 - thread name: " + Thread.currentThread().name)
                // delay 是 suspend 函数
                delay(500)
                Log.e("guohao","launch2 - delay finish ")
                (getName() as MutableLiveData<String>).postValue("form launch 2")
            }

            Log.e("guohao","after launch")
        }
    }

}
