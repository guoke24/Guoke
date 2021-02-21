package com.guohao.guoke.jetpack

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.guohao.guoke.R
import kotlinx.android.synthetic.main.activity_jet_pack_test1.*

// 原本为了测试 ViewModel 的使用，
// 然后又拓展了 屏幕旋转的回调，和 协程的用法
class JetPackTest1Activity : AppCompatActivity() {

    // 静态的
    companion object{

        val TAG = JetPackTest1Activity::class.java.name
        val appName = "guoke"
        val appVersion = 1

        fun start(context: Activity){
            context.startActivity(Intent(context,JetPackTest1Activity::class.java))
        }
    }

    // 动态的
    var viewModel: MyViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jet_pack_test1)
        Log.e(TAG,"onCreate")
        initViewModel()
        btn_1.setOnClickListener {
            viewModel?.loadData()
        }
    }

    private fun initViewModel(){
        //val model: MyViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

        // 普通的 viewModel 就是这么用的
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(MyViewModel::class.java)

        viewModel?.getName()?.observe(this, Observer {
            Log.e("guohao","收到信息 ${it}");
        })

        // 完整写法如下，对比可知，省去了指明泛型。省去了函数的声明，这些都可以推断
        // viewModel.getName() 得到 LiveData<String>，可知泛型为 String
        // Observer 单方法的接口，可直接用 lambda 写函数体，单参数默认为 it
//        viewModel.getName().observe(this, Observer<String>(){
//                fun onChanged(t: String?): Unit{
//
//            }
//        })

    }

    // 旋转屏幕，销毁 Activity 的时候，会调用该函数
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(TAG,"onSaveInstanceState1")
    }

    // 旋转屏幕，销毁 Activity 后又重建 Activity 的时候，会调用该函数
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(TAG,"onRestoreInstanceState1")
    }

}