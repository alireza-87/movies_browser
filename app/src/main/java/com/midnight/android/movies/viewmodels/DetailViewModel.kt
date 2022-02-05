package com.midnight.android.movies.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.midnight.core.domain.DataState
import com.midnight.core.domain.DetailModelCore
import com.midnight.core.usecases.GetDetail
import com.midnight.android.movies.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getDetail: GetDetail):ViewModel() {
    val itemLiveData : MutableLiveData<Event<DataState<DetailModelCore>>> = MutableLiveData()

    fun getDetail(apiKey:String,connected:Boolean,movieId:Int) {
        viewModelScope.launch {
            itemLiveData.value = Event(DataState.Loading)
            getDetail.execute(apiKey , connected ,movieId)?.catch {
                itemLiveData.value = Event(DataState.LocalError())
            }?.collect {
                itemLiveData.value = Event(it)
            }
        }
    }

}