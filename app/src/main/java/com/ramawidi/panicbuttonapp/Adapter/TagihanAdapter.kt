package com.ramawidi.panicbuttonapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramawidi.panicbuttonapp.Data.TagihanData
import com.ramawidi.panicbuttonapp.Holder.TagihanHolder
import com.ramawidi.panicbuttonapp.PaymentDetailActivity
import com.ramawidi.panicbuttonapp.databinding.ItemTagihanBinding


class TagihanAdapter(var listTagihan: ArrayList<TagihanData> = ArrayList()) : RecyclerView.Adapter<TagihanHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TagihanData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagihanHolder {
        val binding = ItemTagihanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TagihanHolder(binding)
    }

    override fun getItemCount(): Int {
        return listTagihan.size
    }

    override fun onBindViewHolder(holder: TagihanHolder, position: Int) {
        val tagihan = listTagihan[position]
        holder.setData(tagihan)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listTagihan[holder.adapterPosition]) }

        // Tambahkan event klik pada item
        holder.itemView.setOnClickListener {
            // Buat Intent untuk membuka PemasanganActivity
            val intent = Intent(holder.itemView.context, PaymentDetailActivity::class.java)

            // Tambahkan data yang diperlukan ke Intent (misalnya, ID tagihan)
            intent.putExtra("payment_code", tagihan.code)
            intent.putExtra("toko_name", tagihan.tokoName)
            intent.putExtra("renewal_status", tagihan.renewal)
            intent.putExtra("payment_status", tagihan.status)
            intent.putExtra("toko_price", tagihan.tokoPrice)
            intent.putExtra("total_price", tagihan.totalPrice)

            // Start Activity dengan Intent
            holder.itemView.context.startActivity(intent)
        }
    }

}