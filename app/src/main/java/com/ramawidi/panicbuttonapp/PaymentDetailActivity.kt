package com.ramawidi.panicbuttonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.ramawidi.panicbuttonapp.databinding.ActivityPaymentDetailBinding

class PaymentDetailActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityPaymentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // back button
        binding.btnSave.setOnClickListener {
            finish()
        }

        // Terima data dari Intent
        val paymentCode = intent.getStringExtra("payment_code")
        binding.code.text = paymentCode

        val tokoName = intent.getStringExtra("toko_name")
        binding.tokoName.text = tokoName

        val renewalStatus = intent.getStringExtra("renewal_status")
        binding.renewal.text = renewalStatus
        // Periksa renewalStatus dan atur visibilitas biaya_pemasangan_layout
        if (renewalStatus == "Perpanjangan Otomatis") {
            binding.biayaPemasanganLayout.visibility = View.GONE
        } else if (renewalStatus == "Pemasangan Baru") {
            binding.biayaPemasanganLayout.visibility = View.VISIBLE
        }

        val paymentStatus = intent.getStringExtra("payment_status")
        // Periksa paymentStatus dan atur latar belakang dan teks status_banner
        if (paymentStatus == "Selesai") {
            binding.statusBanner.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            binding.statusTitle.text = getString(R.string.pembayaran_selesai)
            binding.statusDesc.text = getString(R.string.pembayaran_selesai_desc)
            binding.statusImg.setImageResource(R.drawable.selesai_pembayaran)
            // button save
            binding.iconSave.visibility = View.VISIBLE
            binding.tvSave.text = getString(R.string.bantuan)
        } else if (paymentStatus == "Menunggu") {
            binding.statusBanner.setBackgroundColor(ContextCompat.getColor(this, R.color.orange))
            binding.statusTitle.text = getString(R.string.menunggu_pembayaran)
            binding.statusDesc.text = getString(R.string.menunggu_pembayaran_desc)
            binding.statusImg.setImageResource(R.drawable.menunggu_payment)
            // button save
            binding.iconSave.visibility = View.GONE
            binding.tvSave.text = getString(R.string.bayar_sekarang)
        } else if (paymentStatus == "Pending") {
            binding.statusBanner.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
            binding.statusTitle.text = getString(R.string.pembayaran_pending)
            binding.statusDesc.text = getString(R.string.pembayaran_pending_desc)
            binding.statusImg.setImageResource(R.drawable.pending_payment)
            // button save
            binding.iconSave.visibility = View.VISIBLE
            binding.tvSave.text = getString(R.string.bantuan)
        } else if (paymentStatus == "Kadaluwarsa") {
            binding.statusBanner.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            binding.statusTitle.text = getString(R.string.pembayaran_kadaluwarsa)
            binding.statusDesc.text = getString(R.string.pembayaran_kadaluwarsa_desc)
            binding.statusImg.setImageResource(R.drawable.kadaluwarsa_payment)
            // button save
            binding.iconSave.visibility = View.VISIBLE
            binding.tvSave.text = getString(R.string.bantuan)
        }

        val tokoPrice = intent.getStringExtra("toko_price")
        binding.tokoPrice.text = tokoPrice

        val totalPrice = intent.getStringExtra("total_price")
        binding.totalTagihan.text = totalPrice
        binding.totalPrice.text = totalPrice
    }
}