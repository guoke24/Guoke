package com.guohao.guoke

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.guohao.guoke.jetpack.JetPackTest1Activity
import com.guohao.guokeui.GuokeUIMainActivity
import com.guohao.guokeui.hencoder.HenCoderMainActivity
import com.guohao.guokeui.smallapp.SmallAppMainActivity
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        btn_GuokeUI.setOnClickListener {
            startActivity(Intent(activity, GuokeUIMainActivity::class.java))
        }

        btn_1.setOnClickListener {
            // 作用域函数
            // let 和 run 函数都会返回闭包的执行结果，不同的是 let 有闭包参数，run 没有
            // also 和 apply 函数都不会返回闭包的执行结果，不同的是 also 有闭包参数，apply 没有
            // 因此此处可以用 let 和 also；
            // 由考虑到不需要闭包的执行结果，所以用 let
            activity?.let { it1 -> JetPackTest1Activity.start(it1) }
        }

        btn_HenCoderUI.setOnClickListener {
            startActivity(Intent(activity, HenCoderMainActivity::class.java))
        }

        btn_SmallApp.setOnClickListener {
            startActivity(Intent(activity, SmallAppMainActivity::class.java))
        }

    }
}
