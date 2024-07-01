package com.example.cornflix.model.series

import android.os.Parcelable
import com.example.cornflix.model.media.MediaModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Series(
    @SerializedName("id") override var id: String,
    @SerializedName("name") override var name: String,
    @SerializedName("overview") override var description: String,
    @SerializedName("poster_path") override var poster: String,
    @SerializedName("first_air_date") override var releaseDate: String,
    @SerializedName("vote_average") override var voteAverage: String,
    override var mediaType: String
) : MediaModel, Parcelable