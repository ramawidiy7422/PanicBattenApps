package com.ramawidi.panicbuttonapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.userProfileChangeRequest
import com.ramawidi.panicbuttonapp.databinding.ActivityMain2Binding
import java.util.concurrent.TimeUnit

class MainActivity2 : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Pengecekan apakah pengguna sudah login sebelumnya
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            // Jika sudah login, alihkan ke halaman yang sesuai
            val intent = Intent(this@MainActivity2, loginotpActivity::class.java)
            startActivity(intent)
            finish() // Selesai, agar pengguna tidak bisa kembali ke halaman login
        }

        // Mendefinisikan TextWatchers untuk TextInputEditText
        binding.btnDaftar.setOnClickListener {
            if (binding.edtPhone.text.toString().isEmpty()) {
                binding.edtPhone.error = "Enter Email"
            } else if (binding.edtPasswrd.text.toString().isEmpty()) {
                binding.edtPasswrd.error = "Enter Password"
            } else if (binding.confrmPass.text.toString().isEmpty()) {
                binding.confrmPass.error = "Enter Password Again"
            } else if (!(binding.edtPasswrd.text.toString()
                    .equals(binding.confrmPass.text.toString()))
            ) {
                binding.confrmPass.error = "Password must be the same"
            } else {
                // ...
                // Lakukan operasi yang diperlukan jika pengguna ingin mendaftar
            }
        }

        // to MasukActivity
        binding.btnMasuk.setOnClickListener {
            val intent = Intent(this@MainActivity2, MasukActivity::class.java)
            startActivity(intent)
        }
    }
}

