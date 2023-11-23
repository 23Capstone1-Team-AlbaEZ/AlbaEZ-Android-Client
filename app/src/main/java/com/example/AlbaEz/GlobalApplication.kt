package com.example.AlbaEz

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import android.util.Log
import com.kakao.sdk.common.util.Utility
class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "d4be87432c543840305997a2e113d219")

        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash)
    }
}