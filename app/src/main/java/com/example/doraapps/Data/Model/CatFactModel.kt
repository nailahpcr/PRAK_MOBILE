package com.example.doraapps.Data.Model
import retrofit2.Call
import retrofit2.http.GET
data class CatFactModel(
    val fact: String,
    val length: Int
)