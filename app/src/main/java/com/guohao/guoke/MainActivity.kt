package com.guohao.guoke

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.guohao.guoke.kotlin.OneActivity

import kotlinx.android.synthetic.main.activity_main.*

// class MainActivity extends AppCompatActivity{}
class MainActivity : AppCompatActivity() {

    val instance by lazy {this}  //这里使用了委托，表示只有使用到instance才会执行该段代码

    // 实现一个类，有何区别
    val bb = object : innerClass(){}
    val bb2 = innerClass()

    // 实现一个接口
    val aa = object : View.OnClickListener {
        override fun onClick(v: View?) {
            Toast.makeText(instance,"",Toast.LENGTH_SHORT).show()
        }
    }
    val aa2 = View.OnClickListener{
        v -> Toast.makeText(instance,"",Toast.LENGTH_SHORT).show()
    }

    // override
    // public void onCreate(Bundle savedInstanceState){ ... }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // 新写法 id 直接用
        // {} 包住一个接口的匿名实现类
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    // 传一个 listener
                    .setAction("Action2", object :View.OnClickListener{
                        override fun onClick(v: View?) {
                            TODO("Not yet implemented")
                        }
                    } )
                    // 简单写法
                    .setAction("Action", { v -> Toast.makeText(instance,"",Toast.LENGTH_SHORT).show() })
                    .show()

            // 调整
            startActivity(Intent(this, OneActivity::class.java))
        }
    }

    // 创建右上角的菜单
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // 点击右上角的菜单，新写法 when
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    open class innerClass{
        val num : Int = 0;
    }

}
