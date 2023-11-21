package com.ramawidi.panicbuttonapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.ramawidi.panicbuttonapp.databinding.LogoutInfoBinding

class LogoutDialog (
    private val context: Context,
    private val title: String,
    private val message: String,
    private val onConfirmation: () -> Unit
) {
    fun show() {
        // inflate and binding the layout
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.logout_info, null)
        val binding = LogoutInfoBinding.bind(dialogView)

        // set the title and message of the dialog
        binding.title.text = title
        binding.message.text = message

        // Create an AlertDialog with the inflated custom layout
        val alertDialog = AlertDialog.Builder(context)
            .setView(binding.root)
            .create()

        // Set the window background to be transparent
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // set positive custom view button
        binding.yesBtn.setOnClickListener {
            // Tambahkan tindakan logout di sini
            onConfirmation.invoke()

            // Tambahkan kode logout di sini, misalnya:
            val intent = Intent(context, MasukActivity::class.java)
            context.startActivity(intent)

            // Setelah logout, Anda dapat menutup dialog
            alertDialog.dismiss()
        }

        // set negative custom view button
        binding.noBtn.setOnClickListener {
            alertDialog.dismiss()
        }

        // display the dialog
        alertDialog.show()
    }
}
