package com.example.movieapp.homeSceen.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.model.Movie


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    var allMovieList:List<Movie> = ArrayList<Movie>()
    lateinit var context: Context
    lateinit var movieListenerInterface: MovieListenerInterface

    fun setUpdatedData(allMovieList:List<Movie>, context: Context,movieListenerInterface: MovieListenerInterface){
        this.allMovieList=allMovieList
        this.context=context
        this.movieListenerInterface=movieListenerInterface
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView){
        val posterImg: ImageView = itemView.findViewById(R.id.posterImg)
        val tvMovieTitle: TextView = itemView.findViewById(R.id.tvMovieTitle)
        var movieCard:CardView = itemView.findViewById(R.id.movieCard)

        fun bind(data: Movie){
            Glide.with(context).load(allMovieList[position].imageUrl).into(posterImg)
            tvMovieTitle.text=allMovieList[position].name
            movieCard.setOnClickListener {
                movieListenerInterface.onMovieClickListener(allMovieList[position])
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false);
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return allMovieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        allMovieList.get(position).let { holder.bind(it) }
    }

}