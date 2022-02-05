package com.midnight.android.movies.framwork.repo.local.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.midnight.android.movies.framwork.repo.local.models.DetailModelDb

@Dao
interface DetailDao {

    @Query("SELECT * from tbl_detail where id = :id")
    fun getDetailById(id:Int): DetailModelDb

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetail(data:DetailModelDb):Long

    @Query("DELETE from tbl_detail")
    fun clearData():Int

}