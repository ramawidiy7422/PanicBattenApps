package com.ramawidi.panicbuttonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.ramawidi.panicbuttonapp.databinding.ActivityLoginotpBinding

class loginotpActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityLoginotpBinding
    // edit text
    private val editTexts = mutableListOf<EditText>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginotpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi EditTexts
        editTexts.add(binding.edtOtp1)
        editTexts.add(binding.edtOtp2)
        editTexts.add(binding.edtOtp3)
        editTexts.add(binding.edtOtp4)
        editTexts.add(binding.edtOtp5)
        editTexts.add(binding.edtOtp6)

        // Tambahkan listener ke setiap EditText
        for (i in 0 until editTexts.size) {
            val currentEditText = editTexts[i]
            val nextEditText = if (i < editTexts.size - 1) editTexts[i + 1] else null

            currentEditText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                    if (s?.length == 1 && nextEditText != null) {
                        // Jika panjang teks mencapai 1, pindah ke EditText berikutnya
                        nextEditText.requestFocus()
                    } else if (s?.isEmpty() == true && i > 0) {
                        // Jika teks dihapus, kembali ke EditText sebelumnya
                        val previousEditText = editTexts[i - 1]
                        previousEditText.requestFocus()
                    }

                    // Periksa apakah semua EditText sudah terisi
                    val allEditTextsFilled = editTexts.all { it.text.isNotEmpty() }
                    // Aktifkan atau nonaktifkan tombol Kirim berdasarkan hasil validasi
                    binding.btnKirim.isEnabled = allEditTextsFilled
                }
            })
        }

        // Inisialisasi tombol Kirim
        binding.btnKirim.isEnabled = false // Awalnya nonaktif

        // Tambahkan listener ke tombol Kirim
        binding.btnKirim.setOnClickListener {
            val intent = Intent(this@loginotpActivity, loginotp2Activity::class.java)
            startActivity(intent)
        }
    }
}