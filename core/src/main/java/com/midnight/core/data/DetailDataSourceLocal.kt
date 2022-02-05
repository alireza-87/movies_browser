package com.midnight.core.data

import com.midnight.core.domain.DetailModelCore

interface DetailDataSourceLocal {
    suspend fun getDetailById(movieId:Int):DetailModelCore?
    suspend fun insertDetail(movieDetail:DetailModelCore):Long
    suspend fun insertDetails(movieDetail:List<DetailModelCore>):List<Long>
    suspend fun clearData():Int
}