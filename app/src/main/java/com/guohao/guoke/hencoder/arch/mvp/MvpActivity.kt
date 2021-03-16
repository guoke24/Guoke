package com.guohao.guoke.hencoder.arch.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guohao.guoke.R
import kotlinx.android.synthetic.main.activity_main_arch.*


class MvpActivity : AppCompatActivity(), Presenter.IView {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main_arch)

    Presenter(this).init()
  }

  override fun showData(data: List<String>) {
    data1View.setText(data[0])
    data2View.setText(data[1])
  }
}