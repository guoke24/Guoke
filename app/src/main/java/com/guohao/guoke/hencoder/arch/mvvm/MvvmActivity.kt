package com.guohao.guoke.hencoder.arch.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guohao.guoke.R
import kotlinx.android.synthetic.main.activity_main_arch.*

/**
 * 这里的 Mvvm 就是 Mvp + DataBing
 *
 */
class MvvmActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main_arch)

    ViewModel(data1View, data2View).init()// 传两个 View 给 ViewModel，帮忙绑定内存数据
  }
}