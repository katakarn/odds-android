package com.odds.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odds.movie.databinding.ActivityHomeMovieBinding
import com.odds.movie.login.User
import com.odds.movie.movie.HomeMovieFragment
import com.odds.movie.movie.MovieActivity

class HomeMovieActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeMovieBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(MovieActivity.EXTRA_USER)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, HomeMovieFragment.newInstance(user))
            .commit()
    }

}