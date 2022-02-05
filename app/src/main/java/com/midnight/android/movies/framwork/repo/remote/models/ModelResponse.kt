package com.midnight.android.movies.framwork.repo.remote.models

import com.google.gson.annotations.SerializedName

data class ModelResponse (
    @SerializedName("page")
    val page : Int?,
    @SerializedName("results")
    val results : ArrayList<MovieModelApi>?,
    )