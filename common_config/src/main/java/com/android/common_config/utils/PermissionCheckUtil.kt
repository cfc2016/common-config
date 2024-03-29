package com.android.common_config.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.v4.app.NotificationManagerCompat

/**
 * Created by Administrator on 2018/9/21.
 */

object PermissionCheckUtil {


    /**
     * 通知权限是否打开(api 24以上可以调用)
     */
    fun notifycationEnable(context: Context): Boolean {
        val notification = NotificationManagerCompat.from(context)
        return notification.areNotificationsEnabled()
    }

    /**
     * 跳转到手机设置界面
     */
    fun gotoSet(context: Context) {
        val intent = Intent()
        if (Build.VERSION.SDK_INT >= 26) {
            // android 8.0引导
            intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.packageName)
        } else if (Build.VERSION.SDK_INT >= 21) {
            // android 5.0-7.0
            intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
            intent.putExtra("app_package", context.packageName)
            intent.putExtra("app_uid", context.applicationInfo.uid)
        } else {
            // 其他
            intent.action = "android.settings.APPLICATION_DETAILS_SETTINGS"
            intent.data = Uri.fromParts("package", context.packageName, null)
        }
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)

    }
}
