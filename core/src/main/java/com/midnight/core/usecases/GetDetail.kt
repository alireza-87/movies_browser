package com.midnight.core.usecases

import com.midnight.core.data.DetailRepository
import com.midnight.core.data.MovieRepository
import com.midnight.core.domain.DataState
import com.midnight.core.domain.DetailModelCore
import com.midnight.core.domain.MovieModelCore
import kotlinx.coroutines.flow.Flow

class GetDetail constructor(private val repo:DetailRepository) {
    suspend fun execute(key:String,isConnected:Boolean,movieId:Int): Flow<DataState<DetailModelCore>>? {
        return repo.getDetail(key,movieId, isConnected)
    }

}