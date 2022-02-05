package com.midnight.android.movies.framwork.di

import android.content.Context
import androidx.room.Room
import com.midnight.android.movies.framwork.repo.local.DataBase
import com.midnight.android.movies.framwork.repo.local.interfaces.DetailDao
import com.midnight.android.movies.framwork.repo.local.interfaces.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    private val DB_NAME = "movie.db"

    // ************** PROVIDE DATABASE **************

    @Provides
    fun provideMovieDao(dataBase: DataBase): MovieDao {
        return dataBase.movieDao()
    }

    @Provides
    fun provideDetailDao(dataBase: DataBase): DetailDao {
        return dataBase.detailDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): DataBase {
        return Room.databaseBuilder(
            appContext,
            DataBase::class.java,
            DB_NAME
        ).build()
    }

}