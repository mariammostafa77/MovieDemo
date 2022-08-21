package com.example.movieapp.network

import com.example.movieapp.model.Movie
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface RemoteInterface {
    fun getAllMovies(): Single<List<Movie>>
}