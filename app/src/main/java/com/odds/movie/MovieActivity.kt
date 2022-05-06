package com.odds.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MovieActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

		val user = intent.getParcelableExtra<User>(EXTRA_USER)

	}

	companion object {
		const val EXTRA_USER = "EXTRA_USER"
	}
}

