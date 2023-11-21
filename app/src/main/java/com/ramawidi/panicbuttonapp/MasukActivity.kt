package com.ramawidi.panicbuttonapp

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.databinding.DataBindingUtil.setContentView
import com.google.firebase.auth.FirebaseAuth
import com.ramawidi.panicbuttonapp.databinding.ActivityMasukBinding

class MasukActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMasukBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMasukBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Pengecekan apakah pengguna sudah login sebelumnya
        val currentUser = auth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Selesai, agar pengguna tidak bisa kembali ke halaman login
        }

        binding.btnDaftar.setOnClickListener {
            val intent = Intent(this@MasukActivity, MainActivity2::class.java)
            startActivity(intent)
        }

        binding.btnMasuk.setOnClickListener {
            if (binding.edtPhone.text.toString().isEmpty()) {
                binding.edtPhone.error = "Enter Email"
            } else if (binding.passET.text.toString().isEmpty()) {
                binding.passET.error = "Enter Password"
            } else {
                auth.signInWithEmailAndPassword(
                    binding.edtPhone.text.toString(),
                    binding.passET.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        // Simpan email pengguna ke dalam SharedPreferences
                        val editor = sharedPreferences.edit()
                        editor.putString("userEmail", binding.edtPhone.text.toString())
                        editor.apply()

                        var intent = Intent(this@MasukActivity, loginotp2Activity::class.java)
                        startActivity(intent)
                        finish() // Selesai, agar pengguna tidak bisa kembali ke halaman login
                    } else {
                        Toast.makeText(
                            this@MasukActivity,
                            "Authentication Failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}