package com.ramawidi.panicbuttonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramawidi.panicbuttonapp.Adapter.InformanAdapter
import com.ramawidi.panicbuttonapp.Data.Plassboy
import com.ramawidi.panicbuttonapp.databinding.ActivityInformasiBinding

class InformasiActivity : AppCompatActivity() {
    //binding
    private lateinit var binding: ActivityInformasiBinding

    // list info
    private lateinit var infoList : RecyclerView
    private val list = ArrayList<Plassboy>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        infoList = binding.rvInformasi
        infoList.setHasFixedSize(true)
        list.addAll(getListInformasi())
        showRecyclerList()
    }

    private fun getListInformasi(): Collection<Plassboy> {
        val infoTitle = resources.getStringArray(R.array.info_title)
        val infoDesc = resources.getString(R.string.info_desc)
        val infoImage = resources.obtainTypedArray(R.array.info_picture)
        val listInfo = ArrayList<Plassboy>()

        for (i in infoTitle.indices) {
            val info = Plassboy(infoTitle[i], infoDesc, infoImage.getResourceId(i, 0))
            listInfo.add(info)
        }
        return listInfo
    }

    private fun showRecyclerList() {
        infoList.layoutManager = LinearLayoutManager(this)
        val listInformasiAdapter = InformanAdapter(list)
        infoList.adapter = listInformasiAdapter

        listInformasiAdapter.setOnItemClickCallback(object  : InformanAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Plassboy) {
                showSelectedInfo(data)
            }

        })
    }

    private fun showSelectedInfo(info: Plassboy) {
        val position = list.indexOf(info)
        val intent = Intent(this, DetailInformasiActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }

}