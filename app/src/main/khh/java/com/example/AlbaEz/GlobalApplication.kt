package com.example.AlbaEz

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import android.util.Log
import com.kakao.sdk.common.util.Utility
class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "1c0cbde69cd30713300b94d1f4420b83")

        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash)
    }
}