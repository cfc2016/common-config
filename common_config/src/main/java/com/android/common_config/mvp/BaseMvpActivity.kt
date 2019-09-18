package com.android.common_config.mvp

import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.android.common_config.mvp.dao.IPresenterProxy
import com.android.common_config.base.BaseActivity
import com.android.common_config.net.state.DefaultEmptyCallback
import com.android.common_config.net.state.DefaultErrorCallback
import com.android.common_config.net.state.DefaultLoadingCallback
import com.android.common_config.net.state.DefaultLoadingHasContentCallback
import com.kingja.loadsir.callback.Callback
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir


/**
 * mvp activity基类
 *
 * @author cfc
 * @time 2018/1/19 11:43
 * @desc
 */

abstract class BaseMvpActivity : BaseActivity(), IBaseView {
    protected lateinit var mPresenterProxy: IPresenterProxy
    protected var loadService: LoadService<*>? = null
    private var isRetrying: Boolean = false
    private var mRetryHandler: Handler? = object : Handler() {
        override fun handleMessage(msg: Message?) {
            isRetrying = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        mPresenterProxy = ActivityPresenterProxyImpl(this)
        mPresenterProxy.bindPresenter()
        super.onCreate(savedInstanceState)
    }

    override fun initLoadLayout() {
        val onReloadListener = Callback.OnReloadListener {
            if (!isRetrying) {
                isRetrying = true
                if (mRetryHandler != null) {
                    mRetryHandler!!.sendEmptyMessageDelayed(MESSAGE_RETRY_CODE, 3000)
                    requestData()
                }
            }
        }
        var loadSirTarget = setLoadSirTarget()
        if (loadSirTarget == null) loadSirTarget = this
        loadService = LoadSir.getDefault().register(loadSirTarget, onReloadListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenterProxy.unbindPresenter()
        if (mRetryHandler != null) {
            mRetryHandler!!.removeCallbacksAndMessages(null)
            mRetryHandler = null
        }
    }


    /**
     * 设置状态页面的目标view
     */
    protected open fun setLoadSirTarget(): Any? = null

    /**
     * 请求网络数据(错误重试执行)
     */
    protected open fun requestData() {

    }


    override fun showContent() {
        loadService!!.showSuccess()
    }

    override fun showEmpty() {
        loadService!!.showCallback(DefaultEmptyCallback::class.java)
    }

    override fun showError() {
        loadService!!.showCallback(DefaultErrorCallback::class.java)
    }

    override fun showLoading(showContent: Boolean) {
        if (showContent) {
            loadService!!.showCallback(DefaultLoadingHasContentCallback::class.java)
        } else {
            loadService!!.showCallback(DefaultLoadingCallback::class.java)
        }
    }

    companion object {
        private val MESSAGE_RETRY_CODE = 100
    }

}
