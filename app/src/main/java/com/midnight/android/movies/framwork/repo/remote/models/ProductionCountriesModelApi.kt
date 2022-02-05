package com.midnight.android.movies.framwork.repo.remote.models

import com.google.gson.annotations.SerializedName

data class ProductionCountriesModelApi (
    @SerializedName("iso_3166_1")
    val iso31661 : String?,
    @SerializedName("name")
    val name : String?,

    )