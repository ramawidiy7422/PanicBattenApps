package com.ramawidi.panicbuttonapp.Holder

import androidx.recyclerview.widget.RecyclerView
import com.ramawidi.panicbuttonapp.Data.Plassboy
import com.ramawidi.panicbuttonapp.databinding.ItemRiwayatBinding
import com.ramawidi.panicbuttonapp.databinding.RiwayatPembayaranBinding

class InformanHolder(var item: ItemRiwayatBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(data: Plassboy) {
        item.title.text = data.title
        item.desc.text = data.desc
        item.image.setImageResource(data.image)
    }
}