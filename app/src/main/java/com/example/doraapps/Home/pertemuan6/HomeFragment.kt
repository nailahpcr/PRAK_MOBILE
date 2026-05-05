package com.example.doraapps.Home.pertemuan6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.doraapps.R
import com.example.doraapps.databinding.FragmentHomeBinding

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

        // Set teks deskripsi project
        binding.tvTitle.text = "Project Desa Bansos"
        binding.tvDesc.text =
            "Aplikasi Desa Bansos membantu masyarakat dalam mengakses informasi bantuan sosial secara cepat, transparan, dan tepat sasaran. " +
                    "Melalui sistem ini, data penerima bantuan dapat dikelola dengan lebih efisien serta mendukung program Bina Desa."

        // Tombol ke halaman Web (Bina Desa)
        binding.btnBinaDesa.setOnClickListener {
            (activity as? MainActivityP6)?.let { mainActivity ->
                mainActivity.binding.bottomNavigation.selectedItemId = R.id.nav_web
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}