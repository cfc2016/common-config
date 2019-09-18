package com.android.config.sample

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.android.common_config.utils.toast
import com.android.config.R
import com.tbruyelle.rxpermissions2.RxPermissions

class PermissonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisson)
    }

    fun getLocationPermission(v: View?) {
        val rxPermissions = RxPermissions(this)
        rxPermissions.request(Manifest.permission.ACCESS_FINE_LOCATION).subscribe { granted ->
            if (granted) toast("授权成功！") else toast("授权失败！")
        }
    }
}
