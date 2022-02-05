package com.midnight.android.movies.framwork.repo.local.models

import com.google.gson.annotations.SerializedName

data class SpokenLanguagesModelDb(
    @SerializedName("iso_639_1")
    val iso6391: String,

    @SerializedName("english_name")
    val englishName: String?,
    @SerializedName("name")
    val name: String?,

    )