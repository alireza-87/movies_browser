package com.midnight.android.movies.framwork.repo.local.datasources

import com.midnight.core.data.DetailDataSourceLocal
import com.midnight.core.domain.DetailModelCore
import com.midnight.android.movies.framwork.repo.local.interfaces.DetailDao
import com.midnight.android.movies.framwork.repo.mapper.DetailModelCoreMapper
import com.midnight.android.movies.framwork.repo.mapper.DetailModelLocalMapper
import javax.inject.Inject

class DataSourceDetailLocal @Inject constructor(private val detailDao: DetailDao,private val mapperLocal:DetailModelLocalMapper,private val mapperCore:DetailModelCoreMapper):DetailDataSourceLocal {
    override suspend fun getDetailById(movieId: Int): DetailModelCore? {
        return mapperLocal.toCore(detailDao.getDetailById(id = movieId))
    }

    override suspend fun insertDetail(movieDetail: DetailModelCore): Long {
        return detailDao.insertDetail(mapperCore.toLocal(movieDetail))
    }

    override suspend fun insertDetails(movieDetail: List<DetailModelCore>): List<Long> {
        TODO("Not yet implemented")
    }

    override suspend fun clearData(): Int {
        TODO("Not yet implemented")
    }
}