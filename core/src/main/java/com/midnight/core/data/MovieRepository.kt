package com.midnight.core.data

import com.midnight.core.helper.ApiCallHelper
import com.midnight.core.domain.DataState
import com.midnight.core.domain.MovieModelCore
import com.midnight.core.domain.NetworkErrorType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class MovieRepository constructor(private val dataSourceLocal: MovieDataSourceLocal,private val dataSourceRemote: MovieDataSourceRemote) {
    suspend fun getMovies(key:String,isConnected:Boolean,page:Int,skip:Int,count:Int): Flow<DataState<List<MovieModelCore>>> = flow{
        val dbData = dataSourceLocal.getMovies(skip,count)
        if (dbData.isNullOrEmpty()){
            if (!isConnected) {
                emit(DataState.NetworkError(NetworkErrorType.NetworkConnection()))
            } else {
                ApiCallHelper.safeApiCall { dataSourceRemote.getMovies(key,page) }
                    .catch {
                        emit(DataState.LocalError())
                    }
                    .collect {
                        when (it) {
                            is DataState.Success -> {
                                emit(DataState.Success(it.value))
                                dataSourceLocal.insertMovies(it.value)
                            }
                            is DataState.LocalError -> {
                                emit(DataState.LocalError())
                            }
                            is DataState.NetworkError -> {
                                emit(DataState.NetworkError(it.networkError))
                            }
                            else -> emit(DataState.LocalError())
                        }
                    }
            }
        }else{
            emit(DataState.Success(dbData))
        }

    }.flowOn(Dispatchers.IO).catch {
            emit(DataState.LocalError())
    }

    suspend fun clearMovies():Flow<DataState<Int>> = flow{
        emit(DataState.Success(dataSourceLocal.clearData()))
    }.flowOn(Dispatchers.IO)

}