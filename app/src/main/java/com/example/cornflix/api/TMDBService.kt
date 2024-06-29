package com.example.cornflix.api

import com.example.cornflix.model.MediaResponse
import com.example.cornflix.model.movie.Movie
import com.example.cornflix.model.series.Series
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TMDBService {

    @Headers(
        "Authorization:Bearer $API_KEY",
        "Accept:application/json"
    )
    @GET("tv/popular")
    suspend fun getPopularSeries(@Query("page") page:Int = 1): MediaResponse<Series>

    @Headers(
        "Authorization:Bearer $API_KEY",
        "Accept:application/json"
    )
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page:Int = 1): MediaResponse<Movie>

    companion object {
        const val API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5YjkzZGQ5ZTQzMmM1N2QyZTkzNGU0ZGQ1NDcxMmMzMiIsIm5iZiI6MTcxOTQ4NTc1NC4yMzM2NSwic3ViIjoiNjY3YjJhYzVmYjhjYjFjNmMwNTY3ZTFkIiwic2NvcGVzIjpbImFwaV9yZWFkIl0sInZlcnNpb24iOjF9.hYSNnzpykA8fW0MrqEBxv6wsLZyYOeQQQZvotoADt8s"
    }

}