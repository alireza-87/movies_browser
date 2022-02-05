package com.midnight.core.data

import com.midnight.core.domain.DetailModelCore

interface DetailDataSourceRemote {
    suspend fun getDetailById(movieId:Int,shared:String):DetailModelCore
}