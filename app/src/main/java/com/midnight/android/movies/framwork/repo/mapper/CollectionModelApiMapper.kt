package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.CollectionsModelCore
import com.midnight.android.movies.framwork.repo.local.models.CollectionsModelDb
import com.midnight.android.movies.framwork.repo.remote.models.CollectionsModelApi
import javax.inject.Inject

class CollectionModelApiMapper @Inject constructor() {
    fun toCore(data:CollectionsModelApi?):CollectionsModelCore?{
        data?.let {
            return CollectionsModelCore(
                id = it.id!!,
                name = it.name,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath
            )
        }
        return null

    }

    fun toLocal(data:CollectionsModelApi?) :CollectionsModelDb?{
        data?.let {
            return CollectionsModelDb(
                id = it.id!!,
                name = it.name,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath
            )
        }
        return null
    }
}