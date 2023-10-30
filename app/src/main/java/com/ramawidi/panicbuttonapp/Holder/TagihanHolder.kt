package com.ramawidi.panicbuttonapp.Holder

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ramawidi.panicbuttonapp.Data.TagihanData
import com.ramawidi.panicbuttonapp.R
import com.ramawidi.panicbuttonapp.databinding.ItemTagihanBinding

class TagihanHolder(var item: ItemTagihanBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(data: TagihanData) {
        item.code.text = data.code
        item.renewal.text = data.renewal
        item.tvStatus.text = data.status
        item.time.text = data.time
        item.tokoName.text = data.tokoName
        item.tokoPrice.text = data.tokoPrice
        item.totalPrice.text = data.totalPrice
        item.payBeforeDate.text = data.payBeforeDate
        item.payBeforeHour.text = data.payBeforeHour

        // Atur visibility option_layout
        if (data.status == "Selesai") {
            item.status.setBackgroundColor(ContextCompat.getColor(item.root.context, R.color.green))
        } else if (data.status == "Kadaluwarsa") {
            item.status.setBackgroundColor(ContextCompat.getColor(item.root.context, R.color.red))
        } else if (data.status == "Menunggu") {
            item.status.setBackgroundColor(ContextCompat.getColor(item.root.context, R.color.orange))
        } else if (data.status == "Pending") {
            item.status.setBackgroundColor(ContextCompat.getColor(item.root.context, R.color.yellow))
        }
    }
}