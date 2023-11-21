package com.ramawidi.panicbuttonapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.ramawidi.panicbuttonapp.Adapter.HomeAdapter
import com.ramawidi.panicbuttonapp.Adapter.InformanAdapter
import com.ramawidi.panicbuttonapp.Data.Plassboy
import com.ramawidi.panicbuttonapp.Data.Pragmatic
import com.ramawidi.panicbuttonapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    // Binding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // list info
    private lateinit var infoList : RecyclerView
    private val listInfo = ArrayList<Plassboy>()
    val firebaseAuth = FirebaseAuth.getInstance()
    lateinit var textFullName : TextView
    lateinit var textEmail : TextView
    // list panic
    private lateinit var panicAdapter: HomeAdapter
    private var isListView = true
    private lateinit var panicList : RecyclerView
    private val listPanic = ArrayList<Pragmatic>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inisialisasi FirebaseAuth


        // Toggle view between list and grid when btn_list is clicked
        binding.toggleButton.setOnClickListener {
            isListView = !isListView
            toggleRecyclerViewLayout()
        }
        // floating button
        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(requireContext(), addActivity::class.java)
            startActivity(intent)
        }
        // to InformasiActivity
        binding.btnLihatSemua.setOnClickListener {
            val intent = Intent(requireContext(), InformasiActivity::class.java)
            startActivity(intent)
        }

        // info list
        infoList = binding.rvInformasi
        infoList.setHasFixedSize(true)
        listInfo.addAll(getListInformasi())
        showRecyclerList()

        // panic list
        panicList = binding.rvPanicButton
        panicList.setHasFixedSize(true)
        listPanic.addAll(getListPanic())
        toggleRecyclerViewLayout()

        return view
    }

    private fun toggleRecyclerViewLayout() {
        if (isListView) {
            panicList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.toggleButton.setImageResource(R.drawable.baseline_menu_24)
            panicAdapter = HomeAdapter(initialData = listPanic, viewType = HomeAdapter.VIEW_TYPE_LIST)
        } else {
            panicList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding.toggleButton.setImageResource(R.drawable.icon_grid_view)
            panicAdapter = HomeAdapter(initialData = listPanic, viewType = HomeAdapter.VIEW_TYPE_GRID)
        }

        panicList.adapter = panicAdapter
        panicAdapter.notifyDataSetChanged()
    }

    private fun getListInformasi(): Collection<Plassboy> {
        val infoTitle = resources.getStringArray(R.array.info_title)
        val infoDesc = resources.getString(R.string.info_desc)
        val infoImage = resources.obtainTypedArray(R.array.info_picture)
        val listInfo = ArrayList<Plassboy>()

        // Batasi hanya 5 item pertama
        val itemCount = Math.min(infoTitle.size, 5)

        for (i in 0 until itemCount) {
            val info = Plassboy(infoTitle[i], infoDesc, infoImage.getResourceId(i, 0))
            listInfo.add(info)
        }
        infoImage.recycle()
        return listInfo
    }

    private fun getListPanic() : Collection<Pragmatic> {
        val panicTitle = resources.getStringArray(R.array.toko_name)
        val panicStatus = resources.getStringArray(R.array.toko_status)
        val panicTime = resources.getStringArray(R.array.toko_time)
        val panicImage = resources.obtainTypedArray(R.array.toko_image)
        val listPanic = ArrayList<Pragmatic>()

        for (i in panicTitle.indices) {
            val panic = Pragmatic(panicTitle[i], panicStatus[i], panicTime[i], panicImage.getResourceId(i, 0))
            listPanic.add(panic)
        }
        panicImage.recycle()
        return listPanic
    }

    private fun showRecyclerList() {
        infoList.layoutManager = LinearLayoutManager(requireContext())
        val listInformasiAdapter = InformanAdapter(listInfo)
        infoList.adapter = listInformasiAdapter

        listInformasiAdapter.setOnItemClickCallback(object  : InformanAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Plassboy) {
                showSelectedInfo(data)
            }
        })
    }

    private fun showSelectedInfo(info: Plassboy) {
        val position = listInfo.indexOf(info)
        val intent = Intent(requireContext(), DetailInformasiActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }
}