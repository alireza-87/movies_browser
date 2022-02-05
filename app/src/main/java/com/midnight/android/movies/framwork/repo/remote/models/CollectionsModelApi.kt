package com.midnight.android.movies.framwork.repo.remote.models

import com.google.gson.annotations.SerializedName

data class CollectionsModelApi (
    @SerializedName("id")
    val id : Int?,

    @SerializedName("name")
    val name : String?,

    @SerializedName("poster_path")
    val posterPath : String?,

    @SerializedName("backdrop_path")
    val backdropPath : String?,

    )