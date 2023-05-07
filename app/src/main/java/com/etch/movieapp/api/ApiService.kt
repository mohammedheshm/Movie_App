package com.etch.movieapp.api

import com.etch.movieapp.helper.Constants
import com.etch.movieapp.model.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>

}