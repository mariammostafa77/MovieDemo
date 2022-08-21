package com.example.movieapp.homeSceen.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Communicator
import com.example.movieapp.R
import com.example.movieapp.homeSceen.viewModel.HomeViewModel
import com.example.movieapp.homeSceen.viewModel.HomeViewModelFactory
import com.example.movieapp.model.Movie
import com.example.movieapp.model.Repository
import com.example.movieapp.network.MovieClient

class HomeFragment : Fragment(),MovieListenerInterface {


    lateinit var homeViewModel: HomeViewModel
    lateinit var homeViewModelFactory: HomeViewModelFactory
    lateinit var movieAdapter: MovieAdapter
    lateinit var movieRecycle:RecyclerView
    lateinit var communicator: Communicator


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        movieRecycle=view.findViewById(R.id.movieRecycle)
        movieAdapter= MovieAdapter()
        movieRecycle.adapter = movieAdapter
        communicator = activity as Communicator


        homeViewModelFactory = HomeViewModelFactory(
            Repository.getInstance(
                MovieClient.getInstance(),requireActivity()))

        homeViewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)
        homeViewModel.getAllMovies()
        homeViewModel.allMovies.observe(requireActivity()){
            movieAdapter.setUpdatedData(it,requireContext(),this)
        }


        return view
    }

    override fun onMovieClickListener(movie: Movie) {
        communicator.showDetails(movie)
    }

}