package com.midnight.android.movies.framwork.di

import com.midnight.core.data.DetailRepository
import com.midnight.core.data.MovieRepository
import com.midnight.core.usecases.ClearMovies
import com.midnight.core.usecases.GetDetail
import com.midnight.core.usecases.GetMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UsecaseModule {
    // ************** PROVIDE USE CASE **************
    @Provides
    @Singleton
    fun provideGetMovies(repo: MovieRepository): GetMovies = GetMovies(repo)

    @Provides
    @Singleton
    fun provideGetDetail(repo: DetailRepository): GetDetail = GetDetail(repo)

    @Provides
    @Singleton
    fun provideClearMovies(repo: MovieRepository): ClearMovies = ClearMovies(repo)

}