package com.android.common_config.mvp

import com.android.common_config.mvp.dao.PresenterProxyImpl


/**
 * activity代理类
 * @author cfc
 * @time 2018/1/19 11:55
 * @desc
 */
class ActivityPresenterProxyImpl<V : IBaseView>(view: V) : PresenterProxyImpl<V>(view)
