package com.midnight.core.data

import com.midnight.core.domain.DetailModelCore
import com.midnight.core.domain.MovieModelCore


interface MovieDataSourceRemote {
    suspend fun getMovies(shared:String,page:Int): List<MovieModelCore>
}