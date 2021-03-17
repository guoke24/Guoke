package com.guohao.guoke.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.guohao.guoke.R
import com.guohao.guoke.retrofit.`interface`.WanAndroidService
import com.guohao.guoke.retrofit.model.JsonRootBean
//import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class TestRetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_retrofit)
        //requestByRetrofit()
        requestByOkHttp()
    }

    fun requestByRetrofit(){
        // 构建一个 Retrofit 实例
        val retrofit = Retrofit.Builder()
            .baseUrl("https://wanandroid.com/") // https://wanandroid.com/wxarticle/chapters/json
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // 构建一个接口实例，带有多个方法，即多个路径
        val service = retrofit.create(WanAndroidService::class.java)
        // 此处返回的是一个 WanAndroidService 类的动态代理

        // 构建一个 call 实例，带有一个完整路径
        val wxarticles: Call<JsonRootBean> = service.listWxarticle()
        // 实际执行的是 WanAndroidService 类的动态代理的方法 invoke
        // 方法签名： ... Object invoke(Object proxy, Method method,@Nullable Object[] args)
        // listWxarticle 方法，则是 invoke 方法的 method 参数


        // 异步执行和回调
        wxarticles.enqueue(object : Callback<JsonRootBean> {
            override fun onFailure(call: Call<JsonRootBean>, t: Throwable) {

            }

            override fun onResponse(call: Call<JsonRootBean>, response: Response<JsonRootBean>) {
                Log.i("guohao-retrofit",response.body().toString())
            }

        })
    }

    fun requestByOkHttp(){
        // 第一，新建客户端
        // 第一，新建客户端
        val okHttpClient = OkHttpClient()

        /// 第二，构建请求
        val request = Request.Builder()
            .url("https://wanandroid.com/wxarticle/chapters/json") // 想该 url 发送请求
            .get() //默认就是GET请求，可以不写
            .build()

        // 第三，新建Call
        val call = okHttpClient.newCall(request)

        // 第四，发起调用
        call.enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                println("————失败了$e")
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {

                var stA = response.body()?.string()
                stA.let {
                    Log.i("guohao-okhttp",it)
                }
            }

        })

    }

}

