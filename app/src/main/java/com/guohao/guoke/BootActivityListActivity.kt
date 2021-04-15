package com.guohao.guoke

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class BootActivityListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boot_list)

        val linearLayout = findViewById<LinearLayout>(R.id.ll_container)

        packageManager.getPackageInfo(
            packageName, PackageManager.GET_ACTIVITIES).activities.forEach { activity ->
            // 进入遍历

            if (activity.name == this::class.java.name) {
                return@forEach // 跳出本次循环
            }

            val clazz = Class.forName(activity.name)

            val button = Button(this).apply {
                isAllCaps = false
                text = clazz.simpleName
                setOnClickListener {
                    startActivity(Intent(this@BootActivityListActivity, clazz))
                }
            }
            // 每个 Activity 生成一个按钮
            linearLayout.addView(button)
        }
    }

}