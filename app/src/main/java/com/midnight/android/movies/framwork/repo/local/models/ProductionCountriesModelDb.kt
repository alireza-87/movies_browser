package com.midnight.android.movies.framwork.repo.local.models

import com.google.gson.annotations.SerializedName

data class ProductionCountriesModelDb(
    @SerializedName("iso_3166_1")
    val iso31661: String,

    @SerializedName("name")
    val name: String?,

    )