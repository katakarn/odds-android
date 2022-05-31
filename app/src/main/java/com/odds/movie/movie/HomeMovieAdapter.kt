package com.odds.movie.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.odds.movie.R
import com.odds.movie.databinding.MovieItemRowBinding

class HomeMovieAdapter(val movies: List<Movie>,val onClickMovie: (Movie)-> Unit)
    : RecyclerView.Adapter<HomeMovieAdapter.HomeMovieViewMolder>() {


    class HomeMovieViewMolder(
        private val binding: MovieItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(movie: Movie, onClickMovie: (Movie) -> Unit) {
                Glide.with(binding.imageMovie)
                    .load(movie.image)
                    .error(R.drawable.endgame)
//                    .transition(withCrossFade())
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .into(binding.imageMovie)
//                binding.imageMovie.setImageResource(movie.image?: R.drawable.endgame)
                binding.tvMovieName.text = movie.name
                binding.root.setOnClickListener{onClickMovie(movie)}
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMovieViewMolder {
        val view = MovieItemRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return HomeMovieViewMolder(view)
    }


    override fun onBindViewHolder(holder: HomeMovieViewMolder, position: Int) {
        holder.bind(movies[position], onClickMovie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
