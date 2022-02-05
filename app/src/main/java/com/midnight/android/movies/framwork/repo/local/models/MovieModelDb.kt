package com.midnight.android.movies.framwork.repo.local.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "tbl_movie",
    indices = [Index(value = ["id"], unique = true)]
)
data class MovieModelDb(
    @PrimaryKey()
    @ColumnInfo(name = "id")
    @NonNull val id: Int,
    @ColumnInfo(name = "adult")
    val adult: Boolean?,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String?,
    @ColumnInfo(name = "original_title")
    val originalTitle: String?,
    @ColumnInfo(name = "overview")
    val overview: String?,
    @ColumnInfo(name = "popularity")
    val popularity: Float?,
    @ColumnInfo(name = "poster_path")
    val posterPath: String?,
    @ColumnInfo(name = "release_date")
    val releaseDate: String?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "video")
    val video: Boolean?,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Float?,
    @ColumnInfo(name = "vote_count")
    val voteCount: Float?,
)