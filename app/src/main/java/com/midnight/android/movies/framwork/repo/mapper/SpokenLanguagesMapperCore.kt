package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.SpokenLanguagesModelCore
import com.midnight.android.movies.framwork.repo.local.models.SpokenLanguagesModelDb
import javax.inject.Inject

class SpokenLanguagesMapperCore @Inject constructor(){

    fun toLocal(data:List<SpokenLanguagesModelCore>?):List<SpokenLanguagesModelDb>?{
        return data?.map {
            SpokenLanguagesModelDb(
                iso6391 = it.iso6391!!,
                englishName = it.englishName,
                name = it.name
            )
        }
    }

}