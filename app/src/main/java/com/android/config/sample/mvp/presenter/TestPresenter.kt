package com.android.config.sample.mvp.presenter

import com.android.common_config.net.helper.DefaultException
import com.android.config.sample.mvp.contract.TestContract
import com.android.config.sample.mvp.model.TestModel
import com.android.common_config.mvp.BasePresenter
import com.android.common_config.net.helper.DefaultBaseObserver
import com.android.config.bean.TestBean

/**
 *
 * 类描述：
 * 创建人：cfc
 * 创建时间：2019/3/26 3:23 PM
 * 修改备注：
 **/
class TestPresenter : BasePresenter<TestContract.ITestView>(), TestContract.ITestPresenter {
    private val mTestModel: TestModel = TestModel()

    override fun forTest() {
        val rxBaseObserver = object : DefaultBaseObserver<TestBean>() {
            override fun onStart() {
                view.showLoading(true)
            }

            override fun success(data: TestBean?) {
                view.testSuc()
                view.showContent()
            }

            override fun fail(e: DefaultException) {
                view.testFail()
                view.showError()
            }
        }
        mTestModel.forTest(rxBaseObserver)
        addDisposable(rxBaseObserver)
    }
}