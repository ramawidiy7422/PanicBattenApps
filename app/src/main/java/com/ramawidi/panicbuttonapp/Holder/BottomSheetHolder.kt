package com.ramawidi.panicbuttonapp.Holder

import androidx.recyclerview.widget.RecyclerView
import com.ramawidi.panicbuttonapp.Data.BottomSheetData
import com.ramawidi.panicbuttonapp.databinding.TvBottomDialogBinding

class BottomSheetHolder(var item : TvBottomDialogBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(data: BottomSheetData) {
        item.name.text = data.name
    }
}