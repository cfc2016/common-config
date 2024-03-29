package com.android.config

import com.android.common_config.base.BaseApplication
import com.android.common_config.net.DefaultRetrofitUtil
import com.android.config.sample.api.UrlConstainer

/**
 *
 * 类描述：
 * 创建人：cfc
 * 创建时间：2019/3/26 2:47 PM
 * 修改备注：
 **/
class AppApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        initRetrofit()
    }


    private fun initRetrofit() {
        if (BuildConfig.DEBUG){
            UrlConstainer.appBaseUrl = UrlConstainer.APP_TEST_URL
        }else{
            UrlConstainer.appBaseUrl = UrlConstainer.APP_RELEASE_URL
        }
        DefaultRetrofitUtil.getInstance().init(UrlConstainer.appBaseUrl)
    }


}

