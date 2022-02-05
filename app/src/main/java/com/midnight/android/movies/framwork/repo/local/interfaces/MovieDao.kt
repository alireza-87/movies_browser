package com.midnight.android.movies.framwork.repo.local.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.midnight.android.movies.framwork.repo.local.models.MovieModelDb

@Dao
interface MovieDao {
    @Query("SELECT * from tbl_movie ORDER by popularity DESC LIMIT :skip , :count ")
    fun getMovies(skip:Int,count:Int):List<MovieModelDb>

    @Query("SELECT * from tbl_movie where id = :id")
    fun getMovie(id:String):MovieModelDb

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(data:List<MovieModelDb>):List<Long>

    @Query("DELETE from tbl_movie")
    fun clearData():Int

}