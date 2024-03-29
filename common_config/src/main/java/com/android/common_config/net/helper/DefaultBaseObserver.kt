package com.android.common_config.net.helper

import com.android.common_config.net.bean.DefaultBaseBean
import com.android.common_config.utils.toast
import io.reactivex.observers.DisposableObserver


/**
 *默认Observer(可作为参考用于自定义)
 * @author Administrator
 * @time 2018/8/22 10:14
 */

abstract class DefaultBaseObserver<T> : DisposableObserver<DefaultBaseBean<T>>() {

    override fun onStart() {}

    override fun onNext(tBaseBean: DefaultBaseBean<T>) {
        if (tBaseBean.code == 1) {
            try {
                success(tBaseBean.data)
            } catch (e: Exception) {
                onError(e)
            }
        } else {
            val defaultException = DefaultException(tBaseBean.code, tBaseBean.msg)
            handlerErrorResult(defaultException)
        }
    }

    override fun onError(e: Throwable) {
        val defaultException = DefaultException(e)
        handlerErrorResult(defaultException)
    }

    override fun onComplete() {}


    private fun handlerErrorResult(defaultException: DefaultException) {
        toast(defaultException.msg)
        fail(defaultException)
    }


    abstract fun success(data: T?)

    open fun fail(e: DefaultException) {

    }

}
