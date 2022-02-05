package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.ProductionCompaniesModelCore
import com.midnight.android.movies.framwork.repo.local.models.ProductionCompaniesModelDb
import javax.inject.Inject

class ProductionCompaniesLocalMapper @Inject constructor() {
    fun toCore(data:List<ProductionCompaniesModelDb>?):List<ProductionCompaniesModelCore>?{
        return data?.map {
            ProductionCompaniesModelCore(
                id = it.id!!,
                name = it.name,
                logoPath = it.logoPath,
                originCountry = it.originCountry
            )
        }
    }
}