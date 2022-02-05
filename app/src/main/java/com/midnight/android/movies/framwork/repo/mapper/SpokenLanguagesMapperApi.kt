package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.SpokenLanguagesModelCore
import com.midnight.android.movies.framwork.repo.local.models.SpokenLanguagesModelDb
import com.midnight.android.movies.framwork.repo.remote.models.SpokenLanguagesModelApi
import javax.inject.Inject

class SpokenLanguagesMapperApi @Inject constructor(){

    fun toCore(data:List<SpokenLanguagesModelApi>?):List<SpokenLanguagesModelCore>?{
        return data?.map {
            SpokenLanguagesModelCore(
                iso6391 = it.iso6391!!,
                englishName = it.englishName,
                name = it.name
            )
        }
    }

    fun toLocal(data:List<SpokenLanguagesModelApi>?):List<SpokenLanguagesModelDb>?{
        return data?.map {
            SpokenLanguagesModelDb(
                iso6391 = it.iso6391!!,
                englishName = it.englishName,
                name = it.name
            )
        }
    }

}