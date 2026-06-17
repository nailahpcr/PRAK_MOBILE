package com.example.doraapps.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.example.doraapps.AuthActivity
import com.example.doraapps.databinding.FragmentHomeBinding
import com.example.doraapps.Home.pertemuan10.TenthActivity
import com.example.doraapps.Home.pertemuan13.ThirteenthActivity
import com.example.doraapps.Home.pertemuan2.SecondActivity
import com.example.doraapps.Home.pertemuan3.ThirdActivity
import com.example.doraapps.Home.pertemuan4.FourthActivity
import com.example.doraapps.Home.pertemuan5.FifthActivity
import com.example.doraapps.Home.pertemuan6.MainActivityP6
import com.example.doraapps.Home.pertemuan7.SevenActivity
import com.example.doraapps.Home.pertemuan9.NinthActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireContext().getSharedPreferences("session_user", MODE_PRIVATE)

        // Navigasi Button Pertemuan
        binding.btnP2.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.btnP3.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdActivity::class.java))
        }

        binding.btnP4.setOnClickListener {
            startActivity(Intent(requireContext(), FourthActivity::class.java))
        }

        binding.btnP5.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }

        binding.btnP6.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivityP6::class.java))
        }

        binding.btnP7.setOnClickListener {
            startActivity(Intent(requireContext(), SevenActivity::class.java))
        }

        binding.btnP9.setOnClickListener {
            startActivity(Intent(requireContext(), NinthActivity::class.java))
        }

        binding.btnP10.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }

        binding.btnThirteenth.setOnClickListener {
            startActivity(Intent(requireContext(), ThirteenthActivity::class.java))
        }

        // Fitur Logout
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin Logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    sharedPref.edit { clear() }
                    startActivity(Intent(requireContext(), AuthActivity::class.java))
                    requireActivity().finish()
                    Log.d("HomeFragment", "User logged out")
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}