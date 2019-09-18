package com.android.config

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.android.config.sample.UtilActivity
import com.android.common_config.utils.toast
import com.android.config.adapter.MainAdapter
import com.android.config.sample.NetActivity
import com.android.config.sample.PermissonActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var exitTime: Long = 0

    private val mItemNames = mutableListOf("工具类演示","网络请求演示","权限请求")
    private val mMainAdapter by lazy {
        MainAdapter(this,mItemNames)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()
    }

    private fun initData() {

    }

    private fun initView() {
        rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv.adapter = mMainAdapter
        mMainAdapter.itemClickListener = object: MainAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                itemClickEvent(position)
            }
        }

    }


    private fun itemClickEvent(position: Int) {
        when (position) {
            0 -> {
                start(UtilActivity::class.java)
            }
            1 -> {
                start(NetActivity::class.java)
            }
            2 -> {
                start(PermissonActivity::class.java)
            }
        }
    }


   private fun start(clazz:Class<*>){
        val intent = Intent(this,clazz)
        startActivity(intent)

    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            toast("再按一下退出")
            exitTime = System.currentTimeMillis()
        } else {
            finish()
            System.exit(0)
        }
    }



}
