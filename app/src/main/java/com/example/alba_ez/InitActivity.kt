package com.example.alba_ez

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.alba_ez.databinding.LoginPageBinding

class InitActivity : AppCompatActivity() {

    private lateinit var binding: LoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // btn_login_kakao 클릭 이벤트 설정
        binding.btnLoginKakao.setOnClickListener {
            // 클릭 시에 MainActivity로 이동
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
