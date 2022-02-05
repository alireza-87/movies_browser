package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.MovieModelCore
import com.midnight.android.movies.framwork.repo.local.models.MovieModelDb
import javax.inject.Inject

class MovieModelLocalMapper @Inject constructor() {
    fun toCore(data:List<MovieModelDb>):List<MovieModelCore>{
        return data.map {
            MovieModelCore(
                id = it.id,
                adult = it.adult,
                backdropPath = it.backdropPath,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                video = it.video,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount
            )
        }
    }
}