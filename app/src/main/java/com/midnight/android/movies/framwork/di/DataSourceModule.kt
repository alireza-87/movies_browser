package com.midnight.android.movies.framwork.di

import com.midnight.android.movies.framwork.repo.local.datasources.DataSourceDetailLocal
import com.midnight.android.movies.framwork.repo.local.datasources.DataSourceMoveLocal
import com.midnight.android.movies.framwork.repo.local.interfaces.DetailDao
import com.midnight.android.movies.framwork.repo.local.interfaces.MovieDao
import com.midnight.android.movies.framwork.repo.mapper.*
import com.midnight.android.movies.framwork.repo.remote.datasources.DataSourceDetailRemote
import com.midnight.android.movies.framwork.repo.remote.datasources.DataSourceMovieRemote
import com.midnight.android.movies.framwork.repo.remote.interfaces.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    // ************** PROVIDE SOURCE **************
    @Provides
    @Singleton
    fun provideMovieDataSourceRemote(apiInterface: ApiInterface, mapper: MovieModelRemoteMapper): DataSourceMovieRemote = DataSourceMovieRemote(apiInterface,mapper)

    @Provides
    @Singleton
    fun provideMovieDataSourceLocal(movieDao: MovieDao, mapperLocal: MovieModelLocalMapper,mapperCore:MovieModelCoreMapper): DataSourceMoveLocal = DataSourceMoveLocal(movieDao,mapperLocal,mapperCore)

    //
    @Provides
    @Singleton
    fun provideDetailDataSourceRemote(apiInterface: ApiInterface, mapper: DetailModelApiMapper): DataSourceDetailRemote = DataSourceDetailRemote(apiInterface,mapper)

    @Provides
    @Singleton
    fun provideDetailDataSourceLocal(detailDao: DetailDao, mapperLocal: DetailModelLocalMapper,mapperCore:DetailModelCoreMapper): DataSourceDetailLocal = DataSourceDetailLocal(detailDao,mapperLocal,mapperCore)

}