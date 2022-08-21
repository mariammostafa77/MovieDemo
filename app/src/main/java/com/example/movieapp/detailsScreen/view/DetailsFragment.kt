package com.example.movieapp.detailsScreen.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.movieapp.Communicator
import com.example.movieapp.R
import com.example.movieapp.model.Movie

class DetailsFragment : Fragment() {

    lateinit var tvTitle:TextView
    lateinit var movieImg:ImageView
    lateinit var tvCategory:TextView
    lateinit var tvDesc:TextView
    lateinit var selectedMovie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments!=null){
            selectedMovie= arguments?.getSerializable("movie") as Movie
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        initComponent(view)

        tvTitle.text=selectedMovie.name
        tvDesc.text=selectedMovie.desc
        tvCategory.text=selectedMovie.category
        Glide.with(requireContext()).load(selectedMovie.imageUrl).into(movieImg)

        return view
    }

    private fun initComponent(view:View){
        tvTitle=view.findViewById(R.id.tvTitle)
        movieImg=view.findViewById(R.id.movieImg)
        tvCategory=view.findViewById(R.id.tvCategory)
        tvDesc=view.findViewById(R.id.tvDesc)

    }

}