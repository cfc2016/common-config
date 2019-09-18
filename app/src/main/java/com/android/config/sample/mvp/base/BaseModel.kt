package com.android.config.sample.mvp.base

import com.android.common_config.net.DefaultRetrofitUtil
import com.android.config.sample.api.ApiService


/**
 *
 * 类描述：
 * 创建人：cfc
 * 创建时间：2019/3/26 3:08 PM
 * 修改备注：
 **/
open class BaseModel: IBaseModel {

    override val rxApi: ApiService
        get() = DefaultRetrofitUtil.getInstance().retrofit?.create(ApiService::class.java)!!
}