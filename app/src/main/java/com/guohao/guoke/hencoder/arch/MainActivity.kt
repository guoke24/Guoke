package com.hencoder.arch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guohao.guoke.R
import kotlinx.android.synthetic.main.activity_main_arch.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main_arch)

    val data = DataCenter.getData()
    data1View.setText(data[0])
    data2View.setText(data[1])
  }
}