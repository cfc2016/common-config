package com.android.common_config.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.android.common_config.net.state.DefaultEmptyCallback
import com.android.common_config.net.state.DefaultErrorCallback
import com.android.common_config.net.state.DefaultLoadingCallback
import com.android.common_config.net.state.DefaultLoadingHasContentCallback
import com.android.common_config.utils.UserPref
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir


/**
 * 基类application
 *
 * @author cfc
 * @time 2017/9/1 16:35
 * @desc
 */
open class BaseApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        initLoadSir()
        initSp()
        //bug collection,push,data collection,mutiChannel pack
    }


    open fun initSp() {
        UserPref.setContext(this)
    }

    /**
     *init LoadingLayout
     * @desc if necessary,can override this method.if you do this,you must override the  method such as showContent() etc
     * under of the class for their subclass
     */
    open fun initLoadSir() {
        LoadSir.beginBuilder()
            .addCallback(DefaultErrorCallback())
            .addCallback(DefaultEmptyCallback())
            .addCallback(DefaultLoadingCallback())
            .addCallback(DefaultLoadingHasContentCallback())
            .setDefaultCallback(SuccessCallback::class.java)
            .commit()
    }

}
