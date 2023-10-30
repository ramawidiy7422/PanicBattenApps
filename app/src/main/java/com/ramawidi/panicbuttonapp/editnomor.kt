package com.ramawidi.panicbuttonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramawidi.panicbuttonapp.databinding.ActivityEditnomorBinding

class editnomor : AppCompatActivity() {
    private lateinit var binding: ActivityEditnomorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditnomorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // next button
        binding.btnNext.setOnClickListener {

            // confirmation dialog
            val confirmTitle = getString(R.string.logout_title)
            val confirmText = getString(R.string.logout_desc)

            val updatePhoneDialog = UpdatePhoneDialog(this, confirmTitle, confirmText) {
                val intent = Intent(this, loginotpActivity::class.java)
                startActivity(intent)
            }
            updatePhoneDialog.show()
        }
    }
}