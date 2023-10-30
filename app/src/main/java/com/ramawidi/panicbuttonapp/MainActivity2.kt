package com.ramawidi.panicbuttonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.ramawidi.panicbuttonapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendefinisikan TextWatchers untuk TextInputEditText
        val nameEditText = binding.edtName
        val phoneEditText = binding.edtPhone
        val emailEditText = binding.edtEmail

        val textWatchers = arrayOf(nameEditText, phoneEditText, emailEditText)

        // Mengatur awalnya tombol btnDaftar dalam keadaan nonaktif
        binding.btnDaftar.isEnabled = false

        // Menambahkan TextWatcher ke masing-masing TextInputEditText
        for (editText in textWatchers) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    // Tidak digunakan
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // Tidak digunakan
                }

                override fun afterTextChanged(s: Editable?) {
                    // Cek apakah semua TextInputEditText telah diisi dan checkBox dicentang
                    val isNameFilled = nameEditText.text?.isNotBlank()
                    val isPhoneFilled = phoneEditText.text?.isNotBlank()
                    val isEmailFilled = emailEditText.text?.isNotBlank()
                    val isCheckBoxChecked = binding.checkBox.isChecked

                    // Mengaktifkan atau menonaktifkan tombol btnDaftar berdasarkan kondisi
                    binding.btnDaftar.isEnabled = isNameFilled == true && isPhoneFilled == true && isEmailFilled == true && isCheckBoxChecked
                }
            })
        }

        // to OTPActivity
        binding.btnDaftar.setOnClickListener {
            val intent = Intent(this@MainActivity2, loginotpActivity::class.java)
            startActivity(intent)
        }

        // to MasukActivity
        binding.btnMasuk.setOnClickListener {
            val intent = Intent(this@MainActivity2, MasukActivity::class.java)
            startActivity(intent)
        }
    }
}
