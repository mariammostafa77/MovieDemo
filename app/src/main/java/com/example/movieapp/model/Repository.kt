package com.example.movieapp.model

import android.content.Context
import com.example.movieapp.network.RemoteInterface
import com.example.movieapp.model.Movie
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single


class Repository (var remoteSource: RemoteInterface, var context: Context): RepoInterface{

    companion object{
        private var repository : Repository?= null
        fun getInstance(remoteSource: RemoteInterface,context: Context):Repository{
            return repository?: Repository(remoteSource,context)
        }
    }



    override fun getAllMovies(): Single<List<Movie>> {
        return remoteSource.getAllMovies()
    }
}