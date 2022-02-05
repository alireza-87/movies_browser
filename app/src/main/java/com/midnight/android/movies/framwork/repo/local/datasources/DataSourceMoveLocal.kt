package com.midnight.android.movies.framwork.repo.local.datasources

import com.midnight.core.data.MovieDataSourceLocal
import com.midnight.core.domain.MovieModelCore
import com.midnight.android.movies.framwork.repo.local.interfaces.MovieDao
import com.midnight.android.movies.framwork.repo.mapper.MovieModelCoreMapper
import com.midnight.android.movies.framwork.repo.mapper.MovieModelLocalMapper
import javax.inject.Inject

class DataSourceMoveLocal @Inject constructor(private val movieDao: MovieDao,private val mapperLocal:MovieModelLocalMapper,private val mapperCore:MovieModelCoreMapper): MovieDataSourceLocal {
    override suspend fun getMovies(skip:Int,count:Int): List<MovieModelCore> {
        return mapperLocal.toCore(movieDao.getMovies(skip,count))
    }

    override suspend fun insertMovies(data: List<MovieModelCore>): List<Long> {
        return movieDao.insertMovies(data = mapperCore.toLocal(data))
    }

    override suspend fun clearData(): Int {
        return movieDao.clearData()
    }

}