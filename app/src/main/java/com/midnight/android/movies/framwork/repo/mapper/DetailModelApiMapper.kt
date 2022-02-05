package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.*
import com.midnight.android.movies.framwork.repo.local.models.DetailModelDb
import com.midnight.android.movies.framwork.repo.remote.models.DetailModelApi
import javax.inject.Inject

class DetailModelApiMapper @Inject constructor(private val collectionMapperApi:CollectionModelApiMapper,
                                               private val generesModelApiMapper:GeneresModelApiMapper,
                                                private val productionCountriesApiMapper: ProductionCountriesApiMapper,
                                                private val productionCompaniesApiMapper: ProductionCompaniesApiMapper,
                                                private val spokenLanguagesMapperApi: SpokenLanguagesMapperApi) {
    fun toCore(data:List<DetailModelApi>):List<DetailModelCore>{
        return data.map {
            DetailModelCore(
                id = it.id!!,
                adult = it.adult,
                backdropPath = it.backdropPath,
                collections = collectionMapperApi.toCore(it.collection),
                budget = it.budget,
                genres = generesModelApiMapper.toCore(it.genres),
                homepage = it.homepage,
                imdbId = it.imdbId,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                overview = it.overview,
                popularity = it.popularity,
                productionCompanies = productionCompaniesApiMapper.toCore(it.productionCompanies),
                productionCountries = productionCountriesApiMapper.toCore(it.productionCountries),
                releaseDate = it.releaseDate,
                revenue = it.revenue,
                runtime = it.runtime,
                spokenLanguages = spokenLanguagesMapperApi.toCore(it.spokenLanguages),
                status = it.status,
                tagline = it.tagline,
                title = it.title,
                video = it.video,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,

            )
        }
    }


    fun toCore(it:DetailModelApi):DetailModelCore{
        return DetailModelCore(
            id = it.id!!,
            adult = it.adult,
            backdropPath = it.backdropPath,
            collections = collectionMapperApi.toCore(it.collection),
            budget = it.budget,
            genres = generesModelApiMapper.toCore(it.genres),
            homepage = it.homepage,
            imdbId = it.imdbId,
            originalLanguage = it.originalLanguage,
            originalTitle = it.originalTitle,
            overview = it.overview,
            popularity = it.popularity,
            productionCompanies = productionCompaniesApiMapper.toCore(it.productionCompanies),
            productionCountries = productionCountriesApiMapper.toCore(it.productionCountries),
            releaseDate = it.releaseDate,
            revenue = it.revenue,
            runtime = it.runtime,
            spokenLanguages = spokenLanguagesMapperApi.toCore(it.spokenLanguages),
            status = it.status,
            tagline = it.tagline,
            title = it.title,
            video = it.video,
            voteAverage = it.voteAverage,
            voteCount = it.voteCount,

            )
    }

    fun toLocal(data:List<DetailModelApi>):List<DetailModelDb>{
        return data.map {
            DetailModelDb(
                id = it.id!!,
                adult = it.adult,
                backdropPath = it.backdropPath,
                collections = collectionMapperApi.toLocal(it.collection),
                budget = it.budget,
                genres = generesModelApiMapper.toLocal(it.genres),
                homepage = it.homepage,
                imdbId = it.imdbId,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                overview = it.overview,
                popularity = it.popularity,
                productionCompanies = productionCompaniesApiMapper.toLocal(it.productionCompanies),
                productionCountries = productionCountriesApiMapper.toLocal(it.productionCountries),
                releaseDate = it.releaseDate,
                revenue = it.revenue,
                runtime = it.runtime,
                spokenLanguages = spokenLanguagesMapperApi.toLocal(it.spokenLanguages),
                status = it.status,
                tagline = it.tagline,
                title = it.title,
                video = it.video,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,

                )
        }
    }
}