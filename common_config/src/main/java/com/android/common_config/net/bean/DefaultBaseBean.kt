package com.android.common_config.net.bean

/**
 *
 * 类描述：默认实体类(可作为参考用于自定义)
 * 创建人：cfc
 * 创建时间：2019/3/26 11:12 AM
 * 修改备注：
 **/
 class DefaultBaseBean<T> (val code:Int = 0,
                           val msg:String?,
                           val data: T? )