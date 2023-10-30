package com.ramawidi.panicbuttonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramawidi.panicbuttonapp.databinding.ActivityMasukBinding

class MasukActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityMasukBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMasukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // to OTPActivity
        binding.btnMasuk.setOnClickListener {
            val intent = Intent(this@MasukActivity, loginotpActivity::class.java)
            startActivity(intent)
        }

        // to MainActivity
        binding.btnDaftar.setOnClickListener {
            val intent = Intent(this@MasukActivity, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}