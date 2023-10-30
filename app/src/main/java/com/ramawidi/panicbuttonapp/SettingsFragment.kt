package com.ramawidi.panicbuttonapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ramawidi.panicbuttonapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    // Binding
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root

        // to EditNamaActivity
        binding.edtNama.setOnClickListener {
            val intent = Intent(requireContext(), editnama::class.java)
            startActivity(intent)
        }

        // to EditSelulerActivity
        binding.edtNoSeluler.setOnClickListener {
            val intent = Intent(requireContext(), editnomor::class.java)
            startActivity(intent)
        }

        // to EditEmailActivity
        binding.edtEmail.setOnClickListener {
            val intent = Intent(requireContext(), editmail::class.java)
            startActivity(intent)
        }

        // logout
        binding.btnLogout.setOnClickListener {
            // confirmation dialog
            val confirmTitle = getString(R.string.logout_title)
            val confirmText = getString(R.string.logout_desc)

            val logoutDialog = LogoutDialog(requireContext(), confirmTitle, confirmText) {
                Toast.makeText(requireContext(), "Logout successfully", Toast.LENGTH_SHORT).show()
            }
            logoutDialog.show()
        }

        return view
    }
}