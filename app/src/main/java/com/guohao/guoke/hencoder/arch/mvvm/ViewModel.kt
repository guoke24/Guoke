package com.guohao.guoke.hencoder.arch.mvvm

import android.widget.EditText
import com.hencoder.arch.DataCenter

class ViewModel(data1View: EditText, data2View: EditText) {

  var data1: StringAttr = StringAttr() // 内存数据1
  var data2: StringAttr = StringAttr() // 内存数据2

  init {
    ViewBinder.bind(data1View, data1) // View数据1 双向绑定 内存数据1
    ViewBinder.bind(data2View, data2) // View数据2 双向绑定 内存数据2
  }

  fun init() {
    val data = DataCenter.getData()
    data1.value = data[0]
    data2.value = data[1]
    // 改动内存数据，导致表现数据改动。
    // 而表现数据的改动，从屏幕中操作改动
  }
}