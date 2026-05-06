package com.example.doraapps.Home.pertemuan6

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences("SessionUser", Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun saveLoginStatus(isLoggedIn: Boolean) {
        editor.putBoolean("isLoggedIn", isLoggedIn)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    fun saveUser(name: String, dob: String, gender: String, religion: String, username: String, pass: String) {
        editor.putString("name", name)
        editor.putString("dob", dob)
        editor.putString("gender", gender)
        editor.putString("religion", religion)
        editor.putString("username", username)
        editor.putString("password", pass)
        editor.apply()
    }

    fun saveUsername(username: String) {
        editor.putString("username", username)
        editor.apply()
    }

    fun savePassword(password: String) {
        editor.putString("password", password)
        editor.apply()
    }

    fun getUsername(): String? = sharedPreferences.getString("username", null)
    fun getPassword(): String? = sharedPreferences.getString("password", null)

    fun logout() {
        // Hanya menghapus status login agar data registrasi tidak hilang
        editor.putBoolean("isLoggedIn", false)
        editor.apply()
    }
}