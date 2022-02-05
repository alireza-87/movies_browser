package com.midnight.android.movies.framwork.repo.local.models

import com.google.gson.annotations.SerializedName

data class ProductionCompaniesModelDb(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("logo_path")
    val logoPath: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("origin_country")
    val originCountry: String?,

    )
