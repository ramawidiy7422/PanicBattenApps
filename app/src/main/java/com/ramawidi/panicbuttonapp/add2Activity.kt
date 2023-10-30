package com.ramawidi.panicbuttonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramawidi.panicbuttonapp.databinding.ActivityAdd2Binding

class add2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityAdd2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdd2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // back button
        binding.btnKonfirmasi.setOnClickListener {
            finish()
        }
    }
}