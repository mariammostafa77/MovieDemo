package com.example.movieapp.network

import com.example.movieapp.model.Movie
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class MovieClient private constructor(): RemoteInterface  {
    companion object{
        private var instance:MovieClient?=null
        fun getInstance():MovieClient{
            return instance?: MovieClient()
        }
    }
    override fun getAllMovies(): Single<List<Movie>> {
        val movieService = RetrofitHelper.getRetrofit()?.create(MovieService::class.java)
        return movieService?.getMovies()!!
    }
}

