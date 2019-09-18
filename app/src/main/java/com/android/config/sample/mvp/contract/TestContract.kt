package com.android.config.sample.mvp.contract

import com.android.common_config.mvp.IBaseView

/**
 *
 * 类描述：
 * 创建人：cfc
 * 创建时间：2019/3/26 3:22 PM
 * 修改备注：
 **/
class TestContract {
    interface ITestPresenter {
        fun forTest()
    }

    interface ITestView : IBaseView {
        fun testSuc()
        fun testFail()
    }
}