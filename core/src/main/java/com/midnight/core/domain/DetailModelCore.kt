package com.midnight.core.domain

data class DetailModelCore(
    val id: Int,
    val adult : Boolean?,
    val backdropPath : String?,
    val collections : CollectionsModelCore?,
    val budget : Long?,
    val genres : List<GenresModelCore>?,
    val homepage : String?,
    val imdbId : String?,
    val originalLanguage : String?,
    val originalTitle :String?,
    val overview : String?,
    val popularity : Float?,
    val productionCompanies : List<ProductionCompaniesModelCore>?,
    val productionCountries : List<ProductionCountriesModelCore>?,
    val releaseDate : String?,
    val revenue : Long,
    val runtime : Int?,
    val spokenLanguages : List<SpokenLanguagesModelCore>?,
    val status : String?,
    val tagline : String?,
    val title : String?,
    val video : Boolean?,
    val voteAverage : Float?,
    val voteCount : Int?,


    )
