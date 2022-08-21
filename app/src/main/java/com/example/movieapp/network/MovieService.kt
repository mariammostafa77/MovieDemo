package com.example.movieapp.network

import com.example.movieapp.model.Movie
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MovieService {
    @GET("movielist.json")
    fun getMovies(): Single<List<Movie>>
}