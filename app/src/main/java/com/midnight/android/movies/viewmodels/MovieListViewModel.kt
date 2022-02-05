package com.midnight.android.movies.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.midnight.core.domain.DataState
import com.midnight.core.domain.MovieModelCore
import com.midnight.core.usecases.ClearMovies
import com.midnight.core.usecases.GetMovies
import com.midnight.android.movies.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val getMovies: GetMovies,private val clearMovies: ClearMovies) : ViewModel() {
    val itemLiveData : MutableLiveData<Event<DataState<List<MovieModelCore>>>> = MutableLiveData()
    val clearMoviesLiveData: MutableLiveData<Event<DataState<Int>>> = MutableLiveData()
    fun getMovies(apiKey:String,connected:Boolean,pageNumber:Int=1,skip:Int=0,count:Int=20) {
        viewModelScope.launch {
            itemLiveData.value = Event(DataState.Loading)
            getMovies.execute(apiKey , connected ,pageNumber,skip,count)?.catch {
                itemLiveData.value = Event(DataState.LocalError())
            }?.collect {
                itemLiveData.value = Event(it)
            }
        }
    }

    fun clearMovies(){
        viewModelScope.launch {
            itemLiveData.value = Event(DataState.Loading)
            clearMovies.execute()?.catch {
                clearMoviesLiveData.value = Event(DataState.LocalError())
            }?.collect {
                clearMoviesLiveData.value = Event(it)
            }

        }
    }
}