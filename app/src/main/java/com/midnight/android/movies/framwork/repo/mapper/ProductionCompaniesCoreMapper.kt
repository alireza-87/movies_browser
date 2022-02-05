package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.ProductionCompaniesModelCore
import com.midnight.android.movies.framwork.repo.local.models.ProductionCompaniesModelDb
import javax.inject.Inject

class ProductionCompaniesCoreMapper @Inject constructor() {
    fun toLocal(data:List<ProductionCompaniesModelCore>?):List<ProductionCompaniesModelDb>?{
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