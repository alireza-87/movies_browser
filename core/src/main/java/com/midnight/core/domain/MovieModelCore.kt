package com.midnight.core.domain

data class MovieModelCore (
    val adult : Boolean?,
    val backdropPath : String?,
    val id : Int,
    val originalLanguage : String?,
    val originalTitle : String?,
    val overview : String?,
    val popularity : Float?,
    val posterPath : String?,
    val releaseDate : String?,
    val title : String?,
    val video : Boolean?,
    val voteAverage : Float?,
    val voteCount : Float?,
    ):Comparable<MovieModelCore>,Cloneable{
    override fun compareTo(other: MovieModelCore): Int {
        return if (other.id == this.id)
            1
        else
            0

    }


}