package com.ramawidi.panicbuttonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramawidi.panicbuttonapp.databinding.ActivityDetailInformasiBinding

class DetailInformasiActivity : AppCompatActivity() {
    // binding
    private lateinit var binding : ActivityDetailInformasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailInformasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        val infoTitle = resources.getStringArray(R.array.info_title)
        val infoDesc = resources.getString(R.string.info_desc2)
        val infoImage = resources.obtainTypedArray(R.array.info_picture)

        val position = intent.getIntExtra("position", 0)

        binding.infoTitle.text = infoTitle[position]
        binding.infoImage.setImageResource(infoImage.getResourceId(position, 0))
        binding.infoDesc.text = infoDesc
    }
}