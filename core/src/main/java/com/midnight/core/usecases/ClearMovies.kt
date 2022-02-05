package com.midnight.core.usecases

import com.midnight.core.data.MovieRepository
import com.midnight.core.domain.DataState
import com.midnight.core.domain.MovieModelCore
import kotlinx.coroutines.flow.Flow

class ClearMovies constructor(private val repo: MovieRepository) {
    suspend fun execute(): Flow<DataState<Int>>? {
        return repo.clearMovies()
    }
}