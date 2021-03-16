package com.guohao.guoke.hencoder.arch.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guohao.guoke.R
import com.hencoder.arch.DataCenter
import kotlinx.android.synthetic.main.activity_main_arch_mvc.*


class MvcActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main_arch_mvc)

    val data = DataCenter.getData()
    dataView.showData(data)
  }
}