package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.MovieModelCore
import com.midnight.android.movies.framwork.repo.local.models.MovieModelDb
import com.midnight.android.movies.framwork.repo.remote.models.MovieModelApi
import javax.inject.Inject

class MovieModelRemoteMapper @Inject constructor() {
    fun toCore(data:List<MovieModelApi>):List<MovieModelCore>{
        return data.map {
            MovieModelCore(
                id = it.id!!,
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

    fun toLocal(data:List<MovieModelApi>):List<MovieModelDb>{
        return data.map {
            MovieModelDb(
                id = it.id!!,
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