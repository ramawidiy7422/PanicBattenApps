package com.ramawidi.panicbuttonapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramawidi.panicbuttonapp.Data.Pragmatic
import com.ramawidi.panicbuttonapp.Holder.PanicGridHolder
import com.ramawidi.panicbuttonapp.Holder.PanicListHolder
import com.ramawidi.panicbuttonapp.databinding.GridItemBinding
import com.ramawidi.panicbuttonapp.databinding.ListItemBinding

class HomeAdapter(
    private var initialData: ArrayList<Pragmatic> = ArrayList(),
    private val viewType: Int
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = ArrayList(initialData)

    companion object {
        const val VIEW_TYPE_LIST = 1
        const val VIEW_TYPE_GRID = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_LIST -> {
                val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PanicListHolder(binding.root)
            }
            VIEW_TYPE_GRID -> {
                val binding = GridItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PanicGridHolder(binding.root)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun getItemCount(): Int {
        return initialData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dataItem = initialData[position]

        if (holder is PanicListHolder) {
            holder.bindData(dataItem)
        } else if (holder is PanicGridHolder) {
            holder.bindData(dataItem)
        }
    }
}