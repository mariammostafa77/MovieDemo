package com.example.movieapp

import com.example.movieapp.model.Movie

interface Communicator {
    fun showDetails(movie: Movie)
}