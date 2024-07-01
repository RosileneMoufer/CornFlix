package com.example.cornflix.api

import com.example.cornflix.model.favorites.FavoriteBody
import com.example.cornflix.model.favorites.FavoritesResponse
import com.example.cornflix.model.media.MediaResponse
import com.example.cornflix.model.movie.Movie
import com.example.cornflix.model.series.Series
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
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

    @Headers(
        "Authorization:Bearer $API_KEY",
        "Accept:application/json"
    )
    @POST("account/$ACCOUNT_ID/favorite")
    suspend fun addFavorites(@Body favoritesOptions: FavoriteBody): FavoritesResponse

    @Headers(
        "Authorization:Bearer $API_KEY",
        "Accept:application/json"
    )
    @GET("account/$ACCOUNT_ID/list")
    suspend fun getFavorites(@Query("page") page:Int = 1)

    companion object {
        const val API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5YjkzZGQ5ZTQzMmM1N2QyZTkzNGU0ZGQ1NDcxMmMzMiIsIm5iZiI6MTcxOTQ4NTc1NC4yMzM2NSwic3ViIjoiNjY3YjJhYzVmYjhjYjFjNmMwNTY3ZTFkIiwic2NvcGVzIjpbImFwaV9yZWFkIl0sInZlcnNpb24iOjF9.hYSNnzpykA8fW0MrqEBxv6wsLZyYOeQQQZvotoADt8s"
        const val ACCOUNT_ID = "21349211"
    }

}