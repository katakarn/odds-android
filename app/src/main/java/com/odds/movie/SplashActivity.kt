package com.odds.movie

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.odds.movie.login.LoginActivity

class SplashActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash)

		Handler(Looper.getMainLooper()).postDelayed({
			Intent(this, LoginActivity::class.java).apply {
				val flags =
					Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
				addFlags(flags)
				startActivity(this)
			}
		}, 3000)
	}
}
