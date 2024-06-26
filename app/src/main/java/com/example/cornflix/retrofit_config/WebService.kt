package com.example.cornflix.retrofit_config

import com.example.cornflix.api_response.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey: String
    ): Response<APIResponse>

    @GET("list")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String
    ): Response<APIResponse>
}