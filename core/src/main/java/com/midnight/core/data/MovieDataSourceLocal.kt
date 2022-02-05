package com.midnight.core.data

import com.midnight.core.domain.MovieModelCore


interface MovieDataSourceLocal {
    suspend fun getMovies(skip:Int,count:Int): List<MovieModelCore>
    suspend fun insertMovies(data:List<MovieModelCore>) : List<Long>
    suspend fun clearData():Int
}