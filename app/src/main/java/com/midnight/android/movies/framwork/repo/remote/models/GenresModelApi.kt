package com.midnight.android.movies.framwork.repo.remote.models

import com.google.gson.annotations.SerializedName

data class GenresModelApi (
    @SerializedName("id")
    val id : Int?,
    @SerializedName("name")
    val  name : String?,

    )