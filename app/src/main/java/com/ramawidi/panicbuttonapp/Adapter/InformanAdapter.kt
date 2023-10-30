package com.ramawidi.panicbuttonapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramawidi.panicbuttonapp.Data.Plassboy
import com.ramawidi.panicbuttonapp.Holder.InformanHolder
import com.ramawidi.panicbuttonapp.databinding.ItemRiwayatBinding
import com.ramawidi.panicbuttonapp.databinding.RiwayatPembayaranBinding

class InformanAdapter(var listInfo: ArrayList<Plassboy> = ArrayList()) : RecyclerView.Adapter<InformanHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Plassboy)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformanHolder {
        val binding = ItemRiwayatBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return InformanHolder(binding)
    }

    override fun getItemCount(): Int {
        return listInfo.size
    }

    override fun onBindViewHolder(holder: InformanHolder, position: Int) {
        holder.setData(listInfo[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listInfo[holder.adapterPosition]) }
    }

}