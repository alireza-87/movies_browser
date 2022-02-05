package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.ProductionCountriesModelCore
import com.midnight.android.movies.framwork.repo.local.models.ProductionCountriesModelDb
import com.midnight.android.movies.framwork.repo.remote.models.ProductionCountriesModelApi
import javax.inject.Inject

class ProductionCountriesApiMapper @Inject constructor() {
    fun toCore(data:List<ProductionCountriesModelApi>?):List<ProductionCountriesModelCore>?{
        return data?.map {
            ProductionCountriesModelCore(
                iso31661 = it.iso31661!!,
                name = it.name
            )
        }
    }

    fun toLocal(data:List<ProductionCountriesModelApi>?):List<ProductionCountriesModelDb>?{
        return data?.map {
            ProductionCountriesModelDb(
                iso31661 = it.iso31661!!,
                name = it.name
            )
        }
    }
}