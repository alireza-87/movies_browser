package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.GenresModelCore
import com.midnight.android.movies.framwork.repo.local.models.GenresModelDb
import com.midnight.android.movies.framwork.repo.remote.models.GenresModelApi
import javax.inject.Inject

class GeneresModelApiMapper @Inject constructor() {
    fun toCore(data:List<GenresModelApi>?):List<GenresModelCore>?{
        return data?.map {
            GenresModelCore(
                name = it.name,
                id = it.id!!,
            )
        }
    }

    fun toLocal(data:List<GenresModelApi>?):List<GenresModelDb>?{
        return data?.map {
            GenresModelDb(
                name = it.name,
                id = it.id!!,
            )
        }
    }
}