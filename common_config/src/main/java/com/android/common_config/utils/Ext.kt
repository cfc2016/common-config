package com.android.common_config.utils

import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import com.android.common_config.base.BaseApplication
import com.android.common_config.Constant


/**
 * info print utils
 *@author cfc
 *@time 2019/3/15 6:50 PM
 */
fun Any.toast(msg: String?) {
    if (TextUtils.isEmpty(msg)) return
    try {
        Constant.toast?.apply {
            setText(msg)
            show()
        } ?: run {
            Toast.makeText(BaseApplication.context, null, Toast.LENGTH_SHORT).apply {
                setText(msg)
                setGravity(Gravity.CENTER,0,0)
                Constant.toast = this
            }.show()
        }
    } catch (e: Exception) {
        Toast.makeText(BaseApplication.context, msg, Toast.LENGTH_SHORT).show()
    }
}

fun Any.toast(stringId: Int) {
    toast(BaseApplication.context.getString(stringId))
}

fun Any.logee(msg: String) {
    Log.e(javaClass.simpleName, msg)
}

fun Any.soutt(msg: String) {
    System.err.println("${javaClass.simpleName} ->" + msg)
}
