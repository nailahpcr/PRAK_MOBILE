package com.example.doraapps.Data.API

import com.example.doraapps.Data.Model.CatFactModel
import retrofit2.http.GET

class CatFactApiService {
    interface CatFactApiService {
        @GET("fact")
        suspend fun getCatFact(): CatFactModel
    }
}