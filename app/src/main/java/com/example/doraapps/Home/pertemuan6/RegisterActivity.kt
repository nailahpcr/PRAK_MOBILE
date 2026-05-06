package com.example.doraapps.Home.pertemuan6

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.doraapps.databinding.ActivityRegisterBinding
import java.util.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        setupReligionSpinner()
        setupDatePicker()

        binding.btnRegister.setOnClickListener {
            if (validateForm()) {
                saveData()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        binding.tvLoginLink.setOnClickListener {
            finish()
        }
    }

    private fun setupReligionSpinner() {
        val religions = arrayOf("Islam", "Kristen", "Katolik", "Hindu", "Budha", "Khonghucu")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, religions)
        binding.actvAgama.setAdapter(adapter)
    }

    private fun setupDatePicker() {
        val calendar = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            val date = "$dayOfMonth/${month + 1}/$year"
            binding.etTglLahir.setText(date)
            binding.tilTglLahir.error = null
        }

        binding.etTglLahir.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun validateForm(): Boolean {
        var isValid = true

        val nama = binding.etNama.text.toString().trim()
        val tglLahir = binding.etTglLahir.text.toString().trim()
        val agama = binding.actvAgama.text.toString().trim()
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()

        if (nama.isEmpty()) {
            binding.tilNama.error = "Nama tidak boleh kosong"
            isValid = false
        } else binding.tilNama.error = null

        if (tglLahir.isEmpty()) {
            binding.tilTglLahir.error = "Tanggal lahir harus diisi"
            isValid = false
        } else binding.tilTglLahir.error = null

        if (binding.rgGender.checkedRadioButtonId == -1) {
            binding.tvErrorGender.visibility = View.VISIBLE
            isValid = false
        } else binding.tvErrorGender.visibility = View.GONE

        if (agama.isEmpty()) {
            binding.tilAgama.error = "Pilih agama"
            isValid = false
        } else binding.tilAgama.error = null

        if (username.isEmpty()) {
            binding.tilUsername.error = "Username tidak boleh kosong"
            isValid = false
        } else binding.tilUsername.error = null

        if (password.isEmpty()) {
            binding.tilPassword.error = "Password tidak boleh kosong"
            isValid = false
        } else binding.tilPassword.error = null

        if (confirmPassword != password) {
            binding.tilConfirmPassword.error = "Konfirmasi password tidak cocok"
            isValid = false
        } else if (confirmPassword.isEmpty()) {
            binding.tilConfirmPassword.error = "Ulangi password"
            isValid = false
        } else binding.tilConfirmPassword.error = null

        return isValid
    }

    private fun saveData() {
        val nama = binding.etNama.text.toString()
        val tglLahir = binding.etTglLahir.text.toString()
        val gender = if (binding.rbLaki.isChecked) "Laki-laki" else "Perempuan"
        val agama = binding.actvAgama.text.toString()
        val username = binding.etUsername.text.toString()
        val password = binding.etPassword.text.toString()

        sessionManager.saveUser(nama, tglLahir, gender, agama, username, password)
    }
}