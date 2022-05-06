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
			// Open Login Screen
			val intent = Intent(this, LoginActivity::class.java)
			intent.addFlags(
				Intent.FLAG_ACTIVITY_NEW_TASK
						or Intent.FLAG_ACTIVITY_CLEAR_TOP
						or Intent.FLAG_ACTIVITY_CLEAR_TASK
			)
			startActivity(intent)
		}, 3000)
	}
}
