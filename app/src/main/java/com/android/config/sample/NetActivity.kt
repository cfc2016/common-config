package com.android.config.sample

import android.os.SystemClock
import android.view.View
import com.android.common_config.mvp.BaseMvpActivity
import com.android.common_config.mvp.InjectPresenter
import com.android.common_config.utils.logee
import com.android.config.R
import com.android.config.sample.mvp.contract.TestContract
import com.android.config.sample.mvp.presenter.TestPresenter
import kotlinx.android.synthetic.main.activity_net.*
import kotlin.concurrent.thread

/**
 * 网络请求演示
 */
class NetActivity : BaseMvpActivity(), View.OnClickListener , TestContract.ITestView{



    override fun testSuc() {

    }

    override fun testFail() {
        logee("请求失败！")
    }


    override fun onClick(v: View?) {
        when (v) {
            btn_request -> {
                requestData()
            }
            btn_suc -> {
                monitorRequestSuc()
            }
        }
    }

    private fun monitorRequestSuc() {
        showLoading(false)
        thread {
            SystemClock.sleep(4000)
            runOnUiThread {
                showContent()
            }
        }
    }

    @InjectPresenter
    private lateinit var mTestPresenter: TestPresenter

    override fun setContentView(): Int = R.layout.activity_net

    override fun initData() {
        btn_request.setOnClickListener(this)
        btn_suc.setOnClickListener(this)
    }

    override fun requestData() {
        mTestPresenter.forTest()
    }
}
