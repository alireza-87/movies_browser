package com.midnight.android.movies.framwork.repo.remote.datasources

import com.midnight.core.data.MovieDataSourceRemote
import com.midnight.core.domain.MovieModelCore
import com.midnight.android.movies.framwork.repo.mapper.MovieModelRemoteMapper
import com.midnight.android.movies.framwork.repo.remote.interfaces.ApiInterface
import javax.inject.Inject

class DataSourceMovieRemote @Inject constructor(private val apiInterface: ApiInterface,private val mapperMovie:MovieModelRemoteMapper):MovieDataSourceRemote {
    override suspend fun getMovies(shared: String,page:Int): List<MovieModelCore> {
        return apiInterface.getMovies(shared,page).results?.let { mapperMovie.toCore(it) }!!
    }

}