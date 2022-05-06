package com.odds.movie.movie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.odds.movie.R
import com.odds.movie.login.User
import com.odds.movie.databinding.ActivityHomeMovieBinding

class HomeMovieActivity : AppCompatActivity() {

	private val binding by lazy { ActivityHomeMovieBinding.inflate(layoutInflater) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		setupRecyclerView()
	}

	private fun setupRecyclerView() {
		val movieAdapter = createAdapter()
		val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
		with(binding.recyclerView) {
			setHasFixedSize(true)
			layoutManager = linearLayoutManager
			adapter = movieAdapter
		}
	}

	private fun createAdapter(): HomeMovieAdapter {
		val movies = createMovie()
		return HomeMovieAdapter(movies) {
			val intent = Intent(this, MovieActivity::class.java).apply {
				val user = intent.getParcelableExtra<User>(MovieActivity.EXTRA_USER)
				putExtra(MovieActivity.EXTRA_USER, user)
				putExtra(MovieActivity.EXTRA_MOVIE, it)
			}
			startActivity(intent)
		}
	}

	private fun createMovie(): List<Movie> {
		val endgame = Movie(1, "Avenger: Endgame", R.drawable.endgame, 120)
		val strange = Movie(2, "Dr.Strange", R.drawable.strange, 130)
		val ironMan = Movie(3, "Iron man", R.drawable.tony, 110)
		val thor = Movie(4, "Thor", R.drawable.thor, 180)
		return listOf(endgame, strange, ironMan, thor)
	}
}
