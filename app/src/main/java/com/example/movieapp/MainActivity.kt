package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.movieapp.detailsScreen.view.DetailsFragment
import com.example.movieapp.homeSceen.view.HomeFragment
import com.example.movieapp.model.Movie

class MainActivity : AppCompatActivity(),Communicator {

    var homeFragment = HomeFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragmentWithoutAddToBackStack(homeFragment)
    }
    private fun replaceFragmentWithoutAddToBackStack(fragment: Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
    private fun replaceFragmentWithAddToBackStack(fragment: Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack("")
        transaction.commit()
    }
    override fun showDetails(movie: Movie){
        val bundle=Bundle()
        bundle.putSerializable("movie",movie)
        var detailsFragment = DetailsFragment()
        detailsFragment.arguments=bundle
        replaceFragmentWithAddToBackStack(detailsFragment)
    }
}