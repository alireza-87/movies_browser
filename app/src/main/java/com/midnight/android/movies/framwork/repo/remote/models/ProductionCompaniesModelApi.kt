package com.midnight.android.movies.framwork.repo.remote.models

import com.google.gson.annotations.SerializedName

data class ProductionCompaniesModelApi(
    @SerializedName("id")
    val id : Int?,

    @SerializedName("logo_path")
    val logoPath : String?,

    @SerializedName("name")
    val name : String?,

    @SerializedName("origin_country")
    val originCountry : String?,

    )
