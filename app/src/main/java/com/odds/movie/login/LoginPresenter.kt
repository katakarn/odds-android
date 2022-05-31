package com.odds.movie.login

import com.odds.movie.data.LocalStorange
import com.odds.movie.data.SharePreferenceLocalStorage
import kotlinx.coroutines.*

class LoginPresenter constructor(

    private val dispatcher: CoroutineDispatcher,
    private val duration: Long,
    private val localStrorge: LocalStorange

) {

    //loose coupling, hight cohesion ข้อต่อหลวม, ความสามัคคีสูง
    private lateinit var view: LoginView
    private val scope = CoroutineScope(Job() + dispatcher)

    fun attachView(view: LoginView) {
        this.view = view
    }

    fun askUsername() {
        var username = localStrorge.read()
        view.onUsernameSaved(username)
    }

    interface LoginView {
        fun goToMovieScreen(user: User)
        fun showToastMessage()
        fun showProgressBar()
        fun hideProgressBar()
        fun onUsernameSaved(username: String)
    }

    fun login(username: String, password: String) {
        scope.launch {
            view.showProgressBar()
            delay(duration)

            if (username == "admin" && password == "admin") {
                //navigate to Movie Activity
                val user = User(username, password)
                localStrorge.insert(username)
                view.goToMovieScreen(user)
            } else {
                // Show Toast
                view.showToastMessage()
            }
            view.hideProgressBar()
        }
    }
}