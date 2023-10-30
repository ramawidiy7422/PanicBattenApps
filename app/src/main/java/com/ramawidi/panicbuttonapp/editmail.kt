package com.ramawidi.panicbuttonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramawidi.panicbuttonapp.databinding.ActivityEditmailBinding

class editmail : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityEditmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditmailBinding.inflate(layoutInflater)
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