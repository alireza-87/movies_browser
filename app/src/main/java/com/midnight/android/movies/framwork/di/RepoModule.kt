package com.midnight.android.movies.framwork.di

import com.midnight.core.data.DetailRepository
import com.midnight.core.data.MovieRepository
import com.midnight.android.movies.framwork.repo.local.datasources.DataSourceDetailLocal
import com.midnight.android.movies.framwork.repo.local.datasources.DataSourceMoveLocal
import com.midnight.android.movies.framwork.repo.remote.datasources.DataSourceDetailRemote
import com.midnight.android.movies.framwork.repo.remote.datasources.DataSourceMovieRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {
    // ************** PROVIDE REPO **************
    @Provides
    @Singleton
    fun provideMovieRepository(local: DataSourceMoveLocal, remote: DataSourceMovieRemote): MovieRepository =
        MovieRepository(local,remote)

    @Provides
    @Singleton
    fun provideDetailRepository(local: DataSourceDetailLocal, remote: DataSourceDetailRemote): DetailRepository =
        DetailRepository(local,remote)

}