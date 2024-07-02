package com.example.cornflix.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://api.themoviedb.org/3/"
const val IMAGE_URL = "https://image.tmdb.org/t/p/original"

private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


object RetrofitService{
    val retrofitService by lazy {
        retrofit.create(TMDBService::class.java)
    }
}