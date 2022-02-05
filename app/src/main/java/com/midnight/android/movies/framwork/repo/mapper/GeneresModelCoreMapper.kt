package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.GenresModelCore
import com.midnight.android.movies.framwork.repo.local.models.GenresModelDb
import javax.inject.Inject

class GeneresModelCoreMapper @Inject constructor() {

    fun toLocal(data:List<GenresModelCore>?):List<GenresModelDb>?{
        return data?.map {
            GenresModelDb(
                name = it.name,
                id = it.id!!,
            )
        }
    }
}