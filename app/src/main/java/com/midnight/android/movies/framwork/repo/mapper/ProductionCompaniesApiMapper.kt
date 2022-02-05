package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.ProductionCompaniesModelCore
import com.midnight.android.movies.framwork.repo.local.models.ProductionCompaniesModelDb
import com.midnight.android.movies.framwork.repo.remote.models.ProductionCompaniesModelApi
import javax.inject.Inject

class ProductionCompaniesApiMapper @Inject constructor() {
    fun toCore(data:List<ProductionCompaniesModelApi>?):List<ProductionCompaniesModelCore>?{
        return data?.map {
            ProductionCompaniesModelCore(
                id = it.id!!,
                name = it.name,
                logoPath = it.logoPath,
                originCountry = it.originCountry
            )
        }
    }

    fun toLocal(data:List<ProductionCompaniesModelApi>?):List<ProductionCompaniesModelDb>?{
        return data?.map {
            ProductionCompaniesModelDb(
                id = it.id!!,
                name = it.name,
                logoPath = it.logoPath,
                originCountry = it.originCountry
            )
        }
    }
}