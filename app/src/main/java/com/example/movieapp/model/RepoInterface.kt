package com.example.movieapp.model

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single


interface RepoInterface {
    fun getAllMovies(): Single<List<Movie>>
}