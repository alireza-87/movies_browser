package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.ProductionCountriesModelCore
import com.midnight.android.movies.framwork.repo.local.models.ProductionCountriesModelDb
import javax.inject.Inject

class ProductionCountriesCoreMapper @Inject constructor() {

    fun toLocal(data:List<ProductionCountriesModelCore>?):List<ProductionCountriesModelDb>?{
        return data?.map {
            ProductionCountriesModelDb(
                iso31661 = it.iso31661!!,
                name = it.name
            )
        }
    }
}