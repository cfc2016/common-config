package com.android.common_config.base


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



/**
 * fragment基类
 * Created by on 2017/7/26.
 * 子类在lazyLoad()方法中进行相应处理就可以实现懒加载(仅在pageAdapter中有效果)
 */

abstract class BaseFragment : Fragment() {
    protected lateinit var contentView: View
    protected lateinit var mContext: Context


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mContext = this.activity!!
        contentView = inflater.inflate(setContentView(), container, false)
        initLoadSir(contentView)
        return contentView
    }

    protected abstract fun initLoadSir(contentView: View)

    /**
     * 启动Activity
     *
     * @param clazz
     */
    fun startActivity(clazz: Class<out Activity>) {
        val intent = Intent(mContext, clazz)
        startActivity(intent)
    }

    /**
     * 加载布局
     *
     * @return
     */
    protected abstract fun setContentView(): Int

}
