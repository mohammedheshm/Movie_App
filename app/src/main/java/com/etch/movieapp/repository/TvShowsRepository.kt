package com.etch.movieapp.repository

import com.etch.movieapp.api.ApiService
import javax.inject.Inject

class TvShowsRepository
@Inject
constructor(private val apiService: ApiService) {

    suspend fun getTvShows() = apiService.getTvShows()

}