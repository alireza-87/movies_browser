package com.midnight.android.movies.framwork.repo.mapper

import com.midnight.core.domain.SpokenLanguagesModelCore
import com.midnight.android.movies.framwork.repo.local.models.SpokenLanguagesModelDb
import javax.inject.Inject

class SpokenLanguagesMapperLocal @Inject constructor(){

    fun toCore(data:List<SpokenLanguagesModelDb>?):List<SpokenLanguagesModelCore>?{
        return data?.map {
            SpokenLanguagesModelCore(
                iso6391 = it.iso6391!!,
                englishName = it.englishName,
                name = it.name
            )
        }
    }

}