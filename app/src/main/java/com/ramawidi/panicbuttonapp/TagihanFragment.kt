package com.ramawidi.panicbuttonapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramawidi.panicbuttonapp.Adapter.TagihanAdapter
import com.ramawidi.panicbuttonapp.Data.TagihanData
import com.ramawidi.panicbuttonapp.databinding.FragmentTagihanBinding


class TagihanFragment : Fragment() {
    // binding
    private var _binding: FragmentTagihanBinding? = null
    private val binding get() = _binding!!

    // list tagihan
    private lateinit var tagihanList: RecyclerView
    private val listTagihan = ArrayList<TagihanData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTagihanBinding.inflate(inflater, container, false)
        val view = binding.root

        // tagihan list
        tagihanList = binding.rvTagihan
        tagihanList.setHasFixedSize(true)
        listTagihan.addAll(getListTagihan())
        showRecyclerView()

        return view
    }

    private fun getListTagihan(): Collection<TagihanData> {
        val tCode = resources.getStringArray(R.array.code)
        val tRenewal = resources.getStringArray(R.array.renewal)
        val tStatus = resources.getStringArray(R.array.status)
        val tTime = resources.getStringArray(R.array.time)
        val tName = resources.getStringArray(R.array.toko_name)
        val tPrice = resources.getStringArray(R.array.toko_price)
        val tTotal = resources.getStringArray(R.array.total_price)
        val tPayDate = resources.getStringArray(R.array.pay_before_date)
        val tPayHour = resources.getStringArray(R.array.pay_before_hour)
        val listTagihan = ArrayList<TagihanData>()

        for (i in tCode.indices) {
            val tagihan = TagihanData(tCode[i], tRenewal[i], tStatus[i], tTime[i], tName[i], tPrice[i], tTotal[i], tPayDate[i], tPayHour[i])
            listTagihan.add(tagihan)
        }
        return listTagihan
    }

    private fun showRecyclerView() {
        tagihanList.layoutManager = LinearLayoutManager(requireContext())
        val listTagihanAdapter = TagihanAdapter(listTagihan)
        tagihanList.adapter = listTagihanAdapter
    }
}