package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.CollectionsModelCore
import com.midnight.android.movies.framwork.repo.local.models.CollectionsModelDb
import javax.inject.Inject

class CollectionModelLocalMapper @Inject constructor() {
    fun toCore(data:CollectionsModelDb?):CollectionsModelCore?{
        data?.let {
            CollectionsModelCore(
                id = it.id!!,
                name = it.name,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath
            )
        }
        return null

    }
}