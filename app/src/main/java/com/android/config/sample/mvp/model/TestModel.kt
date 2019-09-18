package com.android.config.sample.mvp.model

import com.android.common_config.net.bean.DefaultBaseBean
import com.android.common_config.net.helper.RxSchedulers
import com.android.config.bean.TestBean
import com.android.config.sample.mvp.base.BaseModel
import io.reactivex.Observer

/**
 *
 * 类描述：
 * 创建人：cfc
 * 创建时间：2019/3/26 3:07 PM
 * 修改备注：
 **/
class TestModel : BaseModel() {

    /**
     * 测试
     */
    fun forTest(observer: Observer<DefaultBaseBean<TestBean>>) {
        rxApi.forTest()
            .compose<DefaultBaseBean<TestBean>>(RxSchedulers.io_main())
            .subscribe(observer)
    }
}