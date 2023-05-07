package com.etch.movieapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etch.movieapp.model.TvShowItem
import com.etch.movieapp.model.TvShowResponse
import com.etch.movieapp.repository.TvShowsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TvShowsViewModel
@Inject
constructor(private val repository: TvShowsRepository) : ViewModel() {

    private val _response = MutableLiveData<List<TvShowItem>>()
    val responseTvShow: LiveData<List<TvShowItem>>
        get() = _response


    init {
        getAllShows()
    }

    private fun getAllShows() = viewModelScope.launch {
        repository.getTvShows().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("tag", "getAllTvShows Error : ${response.message()}")
            }
        }
    }


}