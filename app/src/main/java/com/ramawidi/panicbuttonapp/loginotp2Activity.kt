package com.ramawidi.panicbuttonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramawidi.panicbuttonapp.databinding.ActivityLoginotp2Binding

class loginotp2Activity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityLoginotp2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginotp2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // to OTP2Activity
        binding.btnKirim.setBackgroundResource(R.drawable.gradianet_warna_merah)
        binding.btnKirim.setOnClickListener {
            val intent = Intent(this@loginotp2Activity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}