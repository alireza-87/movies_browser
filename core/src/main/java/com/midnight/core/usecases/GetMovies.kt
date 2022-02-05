package com.midnight.core.usecases

import com.midnight.core.data.MovieRepository
import com.midnight.core.domain.DataState
import com.midnight.core.domain.MovieModelCore
import kotlinx.coroutines.flow.Flow

class GetMovies constructor(private val repo:MovieRepository) {
    suspend fun execute(key:String,isConnected:Boolean,page:Int,skip:Int,count:Int): Flow<DataState<List<MovieModelCore>>>? {
        return repo.getMovies(key, isConnected, page,skip,count)
    }

}