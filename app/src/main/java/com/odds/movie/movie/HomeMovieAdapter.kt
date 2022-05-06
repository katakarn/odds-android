package com.odds.movie.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.odds.movie.databinding.MovieItemRowBinding

class HomeMovieAdapter(
	private val movies: List<Movie>,
	private val onMoviePressed: (Movie) -> Unit
) : RecyclerView.Adapter<HomeMovieAdapter.HomeMovieViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMovieViewHolder {
		val view =
			MovieItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return HomeMovieViewHolder(view)
	}

	override fun onBindViewHolder(holder: HomeMovieViewHolder, position: Int) {
		holder.bind(movie = movies[position], onMoviePressed)
	}

	override fun getItemCount(): Int = movies.size

	class HomeMovieViewHolder(private val binding: MovieItemRowBinding) :
		RecyclerView.ViewHolder(binding.root) {

		fun bind(movie: Movie, onMoviePressed: (Movie) -> Unit) {
			val drawable = ContextCompat.getDrawable(binding.imageMovie.context, movie.image)
			with(binding) {
				tvMovieName.text = movie.name
				imageMovie.setImageDrawable(drawable)
				root.setOnClickListener { onMoviePressed(movie) }
			}
		}

	}
}
