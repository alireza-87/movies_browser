package com.midnight.android.movies.framwork.repo.remote.interfaces

import com.midnight.android.movies.framwork.repo.remote.models.DetailModelApi
import com.midnight.android.movies.framwork.repo.remote.models.ModelResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("3/movie/popular")
    suspend fun getMovies(@Query("api_key") key: String,@Query("page") page:Int = 1) : ModelResponse

    @GET("3/movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId:Int, @Query("api_key") key: String) : DetailModelApi

}