package com.midnight.android.movies.framwork.repo.remote.datasources

import com.midnight.core.data.DetailDataSourceRemote
import com.midnight.core.domain.DetailModelCore
import com.midnight.android.movies.framwork.repo.mapper.DetailModelApiMapper
import com.midnight.android.movies.framwork.repo.remote.interfaces.ApiInterface
import javax.inject.Inject

class DataSourceDetailRemote @Inject constructor(private val apiInterface: ApiInterface,private val mapperDetailModelApi: DetailModelApiMapper):DetailDataSourceRemote {
    override suspend fun getDetailById(movieId: Int,shared:String): DetailModelCore {
        return apiInterface.getMovieDetail(movieId,shared).let {
            mapperDetailModelApi.toCore(it)
        }

    }
}