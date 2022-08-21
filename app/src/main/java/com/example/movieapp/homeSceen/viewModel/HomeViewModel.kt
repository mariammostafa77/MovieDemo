package com.example.movieapp.homeSceen.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.model.Movie
import com.example.movieapp.model.RepoInterface
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class HomeViewModel(private val repo: RepoInterface) : ViewModel() {

    var allMovies = MutableLiveData<List<Movie>>()
    private val onlineMovies : LiveData<List<Movie>> = allMovies

    fun getAllMovies(){
        var observable: Single<List<Movie>> = repo.getAllMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        observable.subscribe({
            allMovies.postValue(it)
            Log.i("TAG","onNext: ${it.size}")
        },{
            Log.i("TAG","Error: $it")
        })
    }

}