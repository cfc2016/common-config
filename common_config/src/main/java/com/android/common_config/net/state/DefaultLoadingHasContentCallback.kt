package com.android.common_config.net.state

import android.content.Context
import android.view.View
import com.android.common_config.R
import com.kingja.loadsir.callback.Callback


/**
 * 加载页面回调(可作为参考用于自定义)
 * @author cfc
 * @time 2018/9/12 10:59
 */

class DefaultLoadingHasContentCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.default_layout_loading
    }

    override fun getSuccessVisible(): Boolean {
        return true
    }

    override fun onReloadEvent(context: Context?, view: View?): Boolean {
        return true
    }
}
