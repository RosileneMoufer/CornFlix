package com.example.cornflix.retrofit_config

import com.example.cornflix.constants.ConstantsAPI
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val webService: WebService by lazy {
        Retrofit.Builder()
            .baseUrl(ConstantsAPI.API_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build().create(...)
    }
}