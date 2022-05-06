package com.odds.movie

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.odds.movie.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

	private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		binding.buttonSubmit.setOnClickListener {
			val username = binding.editTextUsername.text.toString()
			val password = binding.editTextPassword.text.toString()
			binding.progressBar.isVisible = true

			Handler(Looper.getMainLooper()).postDelayed({
				binding.progressBar.isVisible = false
				if (username == "admin" && password == "admin") {
					val user = User(username, password)
					val intent = Intent(this, MovieActivity::class.java)
					intent.putExtra(MovieActivity.EXTRA_USER, user)
					startActivity(intent)
				} else {
					Toast.makeText(
						this,
						"I think your username and password is admin",
						Toast.LENGTH_LONG
					).show()
				}
			}, 3000)

		}
	}

}
