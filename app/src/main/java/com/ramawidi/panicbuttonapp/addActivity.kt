package com.ramawidi.panicbuttonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ramawidi.panicbuttonapp.Adapter.BottomSheetAdapter
import com.ramawidi.panicbuttonapp.Data.BottomSheetData
import com.ramawidi.panicbuttonapp.databinding.ActivityAddBinding

class addActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityAddBinding
    // bottom sheet dialog
    private lateinit var bottomSheetDialog: BottomSheetDialog
    // adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var bottomSheetAdapter: BottomSheetAdapter
    private var list = ArrayList<BottomSheetData>()
    // Declare a variable to hold the selected item
    private var selectedDaerah: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // map
        binding.mapImg.setOnClickListener {
            val intent = Intent(this@addActivity, add2Activity::class.java)
            startActivity(intent)
        }

        // tambah button
        binding.btnTambah.setOnClickListener {
            val namaPanic = binding.edtNamaPanic.text.toString()
            val kecamatan = binding.edtTulisKec.text.toString()
            val kelurahan = binding.edtTulisKel.text.toString()
            val alamat = binding.edtTulisAlamat.text.toString()

            // Validasi input
            if (namaPanic.isEmpty() || kecamatan.isEmpty() || kelurahan.isEmpty() || alamat.isEmpty()) {
                // Salah satu atau lebih EditText kosong, berikan pesan kesalahan
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                finish()
            }
        }

        // kecamatan
        binding.edtTulisKec.setOnClickListener {
            showKecDialog()
        }
        // kelurahan
        binding.edtTulisKel.setOnClickListener {
            showKelDialog()
        }
    }

    private fun showKelDialog() {
        bottomSheetDialog = BottomSheetDialog(this, R.style.BottomSheetTheme)

        // Get the list of kecamatan data
        list = ArrayList(getKelurahanList())

        val dialogView = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
        recyclerView = dialogView.findViewById(R.id.rv_bottom_sheet)

        // Set up the RecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        bottomSheetAdapter = BottomSheetAdapter(list) { selectedItem ->
            selectedDaerah = selectedItem
            binding.edtTulisKel.text = Editable.Factory.getInstance().newEditable(selectedItem)
            bottomSheetDialog.dismiss() // Close the dialog after selecting an item
        }
        recyclerView.adapter = bottomSheetAdapter

        bottomSheetDialog.setContentView(dialogView)
        bottomSheetDialog.show()
    }

    private fun showKecDialog() {
        bottomSheetDialog = BottomSheetDialog(this, R.style.BottomSheetTheme)

        // Get the list of kecamatan data
        list = ArrayList(getKecamatanList())

        val dialogView = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
        recyclerView = dialogView.findViewById(R.id.rv_bottom_sheet)

        // Set up the RecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        bottomSheetAdapter = BottomSheetAdapter(list) { selectedItem ->
            selectedDaerah = selectedItem
            binding.edtTulisKec.text = Editable.Factory.getInstance().newEditable(selectedItem)
            bottomSheetDialog.dismiss() // Close the dialog after selecting an item
        }
        recyclerView.adapter = bottomSheetAdapter

        bottomSheetDialog.setContentView(dialogView)
        bottomSheetDialog.show()
    }

    private fun getKecamatanList(): Collection<BottomSheetData> {
        val kecamatan = resources.getStringArray(R.array.kecamatan)
        val listKec = ArrayList<BottomSheetData>()

        for (i in kecamatan.indices) {
            val kec = BottomSheetData(kecamatan[i])
            listKec.add(kec)
        }
        return listKec
    }

    private fun getKelurahanList(): Collection<BottomSheetData> {
        val kelurahan = resources.getStringArray(R.array.kelurahan)
        val listKel = ArrayList<BottomSheetData>()

        for (i in kelurahan.indices) {
            val kec = BottomSheetData(kelurahan[i])
            listKel.add(kec)
        }
        return listKel
    }
}