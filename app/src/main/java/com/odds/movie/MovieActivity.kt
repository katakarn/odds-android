package com.odds.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odds.movie.databinding.ActivityMovieBinding
import com.odds.movie.login.User
import com.odds.movie.movie.Movie

class MovieActivity : AppCompatActivity() {

	private val binding by lazy { ActivityMovieBinding.inflate(layoutInflater) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		bind()
	}

	private fun bind() {
		val user = intent.getParcelableExtra<User>(EXTRA_USER)
		val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
		with(binding) {
			tvMovieName.text = movie?.name.orEmpty()
			tvDuration.text = String.format(getString(R.string.duration), movie?.duration)
			tvGreeting.text = user?.username.orEmpty()
		}
	}

	companion object {
		const val EXTRA_USER = "EXTRA_USER"
		const val EXTRA_MOVIE = "EXTRA_MOVIE"
	}
}

