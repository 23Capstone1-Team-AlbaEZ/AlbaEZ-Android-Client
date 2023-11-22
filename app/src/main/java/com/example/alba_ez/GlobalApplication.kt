package com.example.alba_ez

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "d4be87432c543840305997a2e113d219")
    }
}