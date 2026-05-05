package com.example.doraapps.Home.pertemuan6

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.doraapps.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupClickListener()
    }

    private fun setupToolbar() {
        val activity = activity as? AppCompatActivity ?: return
        activity.setSupportActionBar(binding.toolbar)
        activity.supportActionBar?.title = "Profile Naila Haura Disanova"
    }

    private fun setupClickListener() {

        // EMAIL NAILA
        binding.tvEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:naila24si@mahasiswa.pcr.ac.id")
            }
            safeStart(intent)
        }

        // LINKEDIN NAILA
        binding.tvLinkedIn.setOnClickListener {
            openUrl("https://www.linkedin.com/in/naila-haura-disanova")
        }

        // GITHUB NAILA
        binding.tvGithub.setOnClickListener {
            openUrl("https://github.com/naila24si")
        }

        // INSTAGRAM NAILA
        binding.tvInstagram.setOnClickListener {
            openUrl("https://www.instagram.com/nailahauraa")
        }

        // --- TOMBOL LOGOUT ---
        binding.btnLogout.setOnClickListener {
            /* Jika kamu punya class SessionManager atau SharedPreferences untuk
               menghapus data login, panggil di sini sebelum pindah halaman.
               Contoh: SessionManager(requireContext()).logout()
            */

            // Pindah ke halaman Login (Pastikan nama LoginActivity sesuai dengan project kamu)
            val intent = Intent(requireContext(), LoginActivity::class.java)

            // Flags ini berfungsi untuk menghapus tumpukan history halaman sebelumnya
            // Jadi setelah logout, user tidak bisa menekan tombol "Back" untuk masuk lagi
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

            Toast.makeText(requireContext(), "Berhasil Logout", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openUrl(url: String) {
        safeStart(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    private fun safeStart(intent: Intent) {
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(requireContext(), "Tidak bisa membuka link", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}