package com.ramawidi.panicbuttonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramawidi.panicbuttonapp.databinding.ActivityEditnamaBinding

class editnama : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityEditnamaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditnamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // save button
        binding.btnSave.setOnClickListener {
            finish()
        }
    }
}