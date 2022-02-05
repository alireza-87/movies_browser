package com.midnight.android.movies.framwork.repo.local.models

import com.google.gson.annotations.SerializedName

data class GenresModelDb(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,

    )