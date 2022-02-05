package com.midnight.android.movies.framwork.repo.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.midnight.android.movies.framwork.repo.local.interfaces.DetailDao
import com.midnight.android.movies.framwork.repo.local.interfaces.MovieDao
import com.midnight.android.movies.framwork.repo.local.models.DetailModelDb
import com.midnight.android.movies.framwork.repo.local.models.MovieModelDb

@Database(
    entities = [MovieModelDb::class,DetailModelDb::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converters::class)
public abstract class DataBase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun detailDao(): DetailDao
}

