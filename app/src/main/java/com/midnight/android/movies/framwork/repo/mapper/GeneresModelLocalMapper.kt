package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.GenresModelCore
import com.midnight.android.movies.framwork.repo.local.models.GenresModelDb
import javax.inject.Inject

class GeneresModelLocalMapper @Inject constructor() {

    fun toCore(data:List<GenresModelDb>?):List<GenresModelCore>?{
        return data?.map {
            GenresModelCore(
                name = it.name,
                id = it.id!!,
            )
        }
    }
}