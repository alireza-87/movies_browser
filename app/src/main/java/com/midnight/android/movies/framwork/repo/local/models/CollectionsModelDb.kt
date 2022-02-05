package com.midnight.android.movies.framwork.repo.local.models

import com.google.gson.annotations.SerializedName

data class CollectionsModelDb(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String?,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    )