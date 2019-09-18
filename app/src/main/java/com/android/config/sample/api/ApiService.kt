package com.android.config.sample.api

import com.android.common_config.net.bean.DefaultBaseBean
import com.android.config.bean.TestBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 *
 * 类描述：
 * 创建人：cfc
 * 创建时间：2019/3/26 3:03 PM
 * 修改备注：
 **/
interface ApiService {

    @GET(UrlConstainer.TEST)
    fun forTest(): Observable<DefaultBaseBean<TestBean>>
}