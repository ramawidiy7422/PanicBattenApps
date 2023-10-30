package com.ramawidi.panicbuttonapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramawidi.panicbuttonapp.Data.BottomSheetData
import com.ramawidi.panicbuttonapp.Holder.BottomSheetHolder
import com.ramawidi.panicbuttonapp.databinding.TvBottomDialogBinding

class BottomSheetAdapter(var daerah: ArrayList<BottomSheetData> = ArrayList(),
                         private val itemClickListener: (String) -> Unit) : RecyclerView.Adapter<BottomSheetHolder>() {
    private var filteredList: ArrayList<BottomSheetData> = ArrayList()

    init {
        filteredList.addAll(daerah)
    }

    fun filter(query: String) {
        filteredList.clear()
        if (query.isEmpty()) {
            filteredList.addAll(daerah)
        } else {
            val searchResults = daerah.filter { it.name.contains(query, true) }
            filteredList.addAll(searchResults)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetHolder {
        val binding = TvBottomDialogBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return BottomSheetHolder(binding)
    }

    override fun getItemCount(): Int {
        return daerah.size
    }

    override fun onBindViewHolder(holder: BottomSheetHolder, position: Int) {
        val data = filteredList[position]
        holder.setData(data)
        holder.itemView.setOnClickListener {
            itemClickListener(data.name)
        }
    }
}