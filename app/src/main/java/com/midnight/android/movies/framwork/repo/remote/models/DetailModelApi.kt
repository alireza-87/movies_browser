package com.midnight.android.movies.framwork.repo.remote.models

import com.google.gson.annotations.SerializedName

data class DetailModelApi(
    @SerializedName("adult")
    val adult : Boolean?,

    @SerializedName("backdrop_path")
    val backdropPath : String?,

    @SerializedName("belongs_to_collection")
    val collection : CollectionsModelApi?,

    @SerializedName("budget")
    val budget : Long?,

    @SerializedName("genres")
    val genres : List<GenresModelApi>?,

    @SerializedName("homepage")
    val homepage : String?,

    @SerializedName("id")
    val id : Int?,

    @SerializedName("imdb_id")
    val imdbId : String?,

    @SerializedName("original_language")
    val originalLanguage : String?,

    @SerializedName("original_title")
    val originalTitle :String?,

    @SerializedName("overview")
    val overview : String?,

    @SerializedName("popularity")
    val popularity : Float?,

    @SerializedName("production_companies")
    val productionCompanies : List<ProductionCompaniesModelApi>?,

    @SerializedName("production_countries")
    val productionCountries : List<ProductionCountriesModelApi>?,

    @SerializedName("release_date")
    val releaseDate : String?,

    @SerializedName("revenue")
    val revenue : Long,

    @SerializedName("runtime")
    val runtime : Int?,

    @SerializedName("spoken_languages")
    val spokenLanguages : List<SpokenLanguagesModelApi>?,

    @SerializedName("status")
    val status : String?,

    @SerializedName("tagline")
    val tagline : String?,

    @SerializedName("title")
    val title : String?,

    @SerializedName("video")
    val video : Boolean?,

    @SerializedName("vote_average")
    val voteAverage : Float?,

    @SerializedName("vote_count")
    val voteCount : Int?,


    )
