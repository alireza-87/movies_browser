package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.*
import com.midnight.android.movies.framwork.repo.local.models.DetailModelDb
import javax.inject.Inject

class DetailModelLocalMapper @Inject constructor(private val collectionMapperLocal:CollectionModelLocalMapper,
                                                 private val generesModelLocalMapper:GeneresModelLocalMapper,
                                                 private val productionCountriesLocalMapper: ProductionCountriesLocalMapper,
                                                 private val productionCompaniesLocalMapper: ProductionCompaniesLocalMapper,
                                                 private val spokenLanguagesMapperLocal: SpokenLanguagesMapperLocal) {


    fun toCore(it:DetailModelDb?):DetailModelCore?{
        it?.let {
            return DetailModelCore(
                id = it?.id!!,
                adult = it.adult,
                backdropPath = it.backdropPath,
                collections = collectionMapperLocal.toCore(it.collections),
                budget = it.budget,
                genres = generesModelLocalMapper.toCore(it.genres),
                homepage = it.homepage,
                imdbId = it.imdbId,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                overview = it.overview,
                popularity = it.popularity,
                productionCompanies = productionCompaniesLocalMapper.toCore(it.productionCompanies),
                productionCountries = productionCountriesLocalMapper.toCore(it.productionCountries),
                releaseDate = it.releaseDate,
                revenue = it.revenue,
                runtime = it.runtime,
                spokenLanguages = spokenLanguagesMapperLocal.toCore(it.spokenLanguages),
                status = it.status,
                tagline = it.tagline,
                title = it.title,
                video = it.video,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,

                )
        }
        return null
    }
}