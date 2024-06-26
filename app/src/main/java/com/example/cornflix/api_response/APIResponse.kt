package com.example.cornflix.api_response

import com.example.cornflix.models.MoviesModel
import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("results")
    var results: List<MoviesModel>
)
