package com.albaez.albaez_client

import android.content.Context

class AssetLoader {

    // 파일 이름을 받아서 해당 파일의 JSON 문자열을 반환하는 함수
    fun getJsonString(context:Context,fileName: String): String? {
        return kotlin.runCatching {
            loadAsset(context,fileName)
        }.getOrNull()
    }

    // Asset 폴더에서 파일을 읽어와서 문자열로 반환하는 함수
    private fun loadAsset(context:Context,fileName: String): String {
        return context.assets.open(fileName).use { inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            String(bytes)
        }
    }
}