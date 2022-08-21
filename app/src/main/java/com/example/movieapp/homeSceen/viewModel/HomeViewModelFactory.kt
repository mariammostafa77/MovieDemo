package com.example.movieapp.homeSceen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.model.Repository
import java.lang.IllegalArgumentException


class HomeViewModelFactory (val repo: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
            HomeViewModel(repo) as T
        }
        else{
            throw IllegalArgumentException("This Class not found")
        }
    }
}