package com.ramawidi.panicbuttonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ramawidi.panicbuttonapp.databinding.ActivityDetailPanicBinding

class DetailPanicActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityDetailPanicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPanicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // help button
        binding.btnBantuan.setOnClickListener {
            finish()
        }

        val panicName = intent.getStringExtra("title_panic")
        binding.panicName.text = panicName

        val panicStatus = intent.getStringExtra("status_panic")
        binding.status.text = panicStatus
        if (panicStatus == "Online") {
            binding.statusCircle.setImageResource(R.drawable.baseline_circle_24)
        } else if (panicStatus == "Offline") {
            binding.statusCircle.setImageResource(R.drawable.lingkarap_abuabu)
        } else if (panicStatus == "Maintenance") {
            binding.statusCircle.setImageResource(R.drawable.buletan_warna_kuning)
        } else if (panicStatus == "Menunggu Pemasangan") {
            binding.statusCircle.setImageResource(R.drawable.lingkarap_abuabu)
            binding.timeImg.visibility = View.GONE
            binding.terakhirDiperbarui.visibility = View.GONE
            binding.time.visibility = View.GONE
        }

        val panicTime = intent.getStringExtra("time_panic")
        binding.time.text = panicTime
    }
}