package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.*
import com.midnight.android.movies.framwork.repo.local.models.DetailModelDb
import javax.inject.Inject

class DetailModelCoreMapper @Inject constructor(private val collectionMapperCore:CollectionModelCoreMapper,
                                                private val generesModelCoreMapper:GeneresModelCoreMapper,
                                                private val productionCountriesCoreMapper: ProductionCountriesCoreMapper,
                                                private val productionCompaniesCoreMapper: ProductionCompaniesCoreMapper,
                                                private val spokenLanguagesMapperCore: SpokenLanguagesMapperCore) {


    fun toLocal(it:DetailModelCore):DetailModelDb {
        return DetailModelDb(
            id = it.id!!,
            adult = it.adult,
            backdropPath = it.backdropPath,
            collections = collectionMapperCore.toLocal(it.collections),
            budget = it.budget,
            genres = generesModelCoreMapper.toLocal(it.genres),
            homepage = it.homepage,
            imdbId = it.imdbId,
            originalLanguage = it.originalLanguage,
            originalTitle = it.originalTitle,
            overview = it.overview,
            popularity = it.popularity,
            productionCompanies = productionCompaniesCoreMapper.toLocal(it.productionCompanies),
            productionCountries = productionCountriesCoreMapper.toLocal(it.productionCountries),
            releaseDate = it.releaseDate,
            revenue = it.revenue,
            runtime = it.runtime,
            spokenLanguages = spokenLanguagesMapperCore.toLocal(it.spokenLanguages),
            status = it.status,
            tagline = it.tagline,
            title = it.title,
            video = it.video,
            voteAverage = it.voteAverage,
            voteCount = it.voteCount,

            )

    }
}