package com.midnight.android.movies.framwork.repo.local.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "tbl_detail",
    indices = [Index(value = ["id"], unique = true)]
)
data class DetailModelDb(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull val id: Int,
    @ColumnInfo(name = "adult")
    val adult: Boolean?,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,
    @ColumnInfo(name = "belongs_to_collection")
    val collections: CollectionsModelDb?,

    @ColumnInfo(name = "budget")
    val budget: Long?,

    @ColumnInfo(name = "genres")
    val genres: List<GenresModelDb>?,

    @ColumnInfo(name = "homepage")
    val homepage: String?,

    @ColumnInfo(name = "imdb_id")
    val imdbId: String?,

    @ColumnInfo(name = "original_language")
    val originalLanguage: String?,

    @ColumnInfo(name = "original_title")
    val originalTitle: String?,

    @ColumnInfo(name = "overview")
    val overview: String?,

    @ColumnInfo(name = "popularity")
    val popularity: Float?,

    @ColumnInfo(name = "production_companies")
    val productionCompanies: List<ProductionCompaniesModelDb>?,

    @ColumnInfo(name = "production_countries")
    val productionCountries: List<ProductionCountriesModelDb>?,

    @ColumnInfo(name = "release_date")
    val releaseDate: String?,

    @ColumnInfo(name = "revenue")
    val revenue: Long,

    @ColumnInfo(name = "runtime")
    val runtime: Int?,

    @ColumnInfo(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguagesModelDb>?,

    @ColumnInfo(name = "status")
    val status: String?,

    @ColumnInfo(name = "tagline")
    val tagline: String?,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "video")
    val video: Boolean?,

    @ColumnInfo(name = "vote_average")
    val voteAverage: Float?,

    @ColumnInfo(name = "vote_count")
    val voteCount: Int?,


    )
