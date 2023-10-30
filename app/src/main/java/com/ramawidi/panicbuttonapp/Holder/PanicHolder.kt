package com.ramawidi.panicbuttonapp.Holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ramawidi.panicbuttonapp.Data.Pragmatic
import com.ramawidi.panicbuttonapp.R
import com.ramawidi.panicbuttonapp.databinding.GridItemBinding
import com.ramawidi.panicbuttonapp.databinding.ListItemBinding

interface PanicHolderInterface {
    fun bindData(data: Pragmatic)
}

// holder for list view
class PanicListHolder(itemView: View) : RecyclerView.ViewHolder(itemView), PanicHolderInterface {
    private val binding = ListItemBinding.bind(itemView)

    override fun bindData(data: Pragmatic) {
        with(binding) {
            // title
            title.text = data.title
            // status
            status.text = data.status
            //status circle
            if (data.status == "Online") {
                statusCircle.setImageResource(R.drawable.baseline_circle_24)
            } else if (data.status == "Offline") {
                statusCircle.setImageResource(R.drawable.lingkarap_abuabu)
            }  else if (data.status == "Maintenance") {
                statusCircle.setImageResource(R.drawable.buletan_warna_kuning)
            }else if (data.status == "Menunggu Pemasangan") {
                statusCircle.setImageResource(R.drawable.lingkarap_abuabu)
            }
            // time
            time.text = data.time
            if (data.status == "Menunggu Pemasangan") {
                timeLayout.visibility = View.INVISIBLE
            } else {
                timeLayout.visibility = View.VISIBLE
            }
            // image
            mapImg.setImageResource(data.mapImg)
        }
    }
}

// holder for grid view
class PanicGridHolder(itemView: View) : RecyclerView.ViewHolder(itemView), PanicHolderInterface {
    private val binding = GridItemBinding.bind(itemView)

    override fun bindData(data: Pragmatic) {
        with(binding) {
            // title
            title.text = data.title
            // status
            status.text = data.status
            //status circle
            if (data.status == "Online") {
                statusCircle.setImageResource(R.drawable.baseline_circle_24)
            } else if (data.status == "Offline") {
                statusCircle.setImageResource(R.drawable.lingkarap_abuabu)
            }  else if (data.status == "Maintenance") {
                statusCircle.setImageResource(R.drawable.buletan_warna_kuning)
            }else if (data.status == "Menunggu Pemasangan") {
                statusCircle.setImageResource(R.drawable.lingkarap_abuabu)
            }
            // time
            time.text = data.time
            if (data.status == "Menunggu Pemasangan") {
                timeLayout.visibility = View.INVISIBLE
            } else {
                timeLayout.visibility = View.VISIBLE
            }
            // image
            mapImg.setImageResource(data.mapImg)
        }
    }
}