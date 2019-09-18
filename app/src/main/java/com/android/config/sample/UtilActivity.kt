package com.android.config.sample

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

import com.android.common_config.utils.GlideUtil
import com.android.common_config.utils.logee
import com.android.common_config.utils.toast
import com.android.config.R
import kotlinx.android.synthetic.main.activity_util.*

/**
 *工具类演示
 *@author cfc
 *@time 2019/3/26 3:45 PM
 */
@SuppressLint("Registered")
class UtilActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        when (v) {
            btn_general -> {
                Toast.makeText(this, "cfc", Toast.LENGTH_SHORT).show()
            }
            btn_purple -> {
                logee("cfc")
                toast( "cfc")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_util)
        initView()
    }

    private fun initView() {
        btn_general.setOnClickListener(this)
        btn_purple.setOnClickListener(this)
        GlideUtil.loadCircle(this,"http://pic26.nipic.com/20121227/10193203_131357536000_2.jpg",iv_img,R.mipmap.ic_launcher,R.mipmap.ic_launcher)
    }
}
