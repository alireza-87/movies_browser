package com.midnight.core.data

import com.midnight.core.domain.DataState
import com.midnight.core.domain.DetailModelCore
import com.midnight.core.domain.MovieModelCore
import com.midnight.core.domain.NetworkErrorType
import com.midnight.core.helper.ApiCallHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class DetailRepository constructor(private val dataSourceLocal: DetailDataSourceLocal,private val dataSourceRemote: DetailDataSourceRemote) {

    suspend fun getDetail(key:String,movieId:Int,isConnected:Boolean): Flow<DataState<DetailModelCore>> = flow{
        val dbData = dataSourceLocal.getDetailById(movieId)
        dbData?.let {
            emit(DataState.Success(dbData))
        }
        if (!isConnected) {
            emit(DataState.NetworkError(NetworkErrorType.NetworkConnection()))
        } else {
            ApiCallHelper.safeApiCall { dataSourceRemote.getDetailById(movieId,key) }
                .catch {
                    emit(DataState.LocalError())
                }
                .collect {
                    when (it) {
                        is DataState.Success -> {
                            emit(DataState.Success(it.value))
                            dataSourceLocal.insertDetail(it.value)
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
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(DataState.LocalError())
        }


}