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
			val user = createUser()
			binding.progressBar.isVisible = true
			Handler(Looper.getMainLooper()).postDelayed({
				binding.progressBar.isVisible = false
				login(user)
			}, 3000)
		}
	}

	private fun login(user: User) {
		if (user.username == "admin" && user.password == "admin") {
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
	}

	private fun createUser(): User {
		val username = binding.editTextUsername.text.toString()
		val password = binding.editTextPassword.text.toString()
		val user = User(username, password)
		return user
	}

}
