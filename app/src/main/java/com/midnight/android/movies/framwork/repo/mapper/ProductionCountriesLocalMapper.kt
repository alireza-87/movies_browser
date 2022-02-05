package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.ProductionCountriesModelCore
import com.midnight.android.movies.framwork.repo.local.models.ProductionCountriesModelDb
import javax.inject.Inject

class ProductionCountriesLocalMapper @Inject constructor() {
    fun toCore(data:List<ProductionCountriesModelDb>?):List<ProductionCountriesModelCore>?{
        return data?.map {
            ProductionCountriesModelCore(
                iso31661 = it.iso31661!!,
                name = it.name
            )
        }
    }

}