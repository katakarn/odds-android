package com.odds.movie.login

import kotlinx.coroutines.*
import java.time.Duration

class LoginPresenter constructor(
    private val dispatcher: CoroutineDispatcher,
    private val duration: Long){

    //loose coupling, hight cohesion ข้อต่อหลวม, ความสามัคคีสูง
    private lateinit var view: LoginView
    private val scope = CoroutineScope(Job() + dispatcher)

    fun attachView(view:LoginView){
        this.view = view
    }

    interface LoginView {
        fun goToMovieScreeen(user: User)
        fun showToastMessage()
        fun showProgressBar()
        fun hideProgressBar()
    }

    fun login(username: String, password: String) {
        scope.launch {
            view.showProgressBar()
            delay(duration)

            if (username == "admin" && password == "admin") {
                //navigate to Movie Activity
                val user = User(username, password)
                view.goToMovieScreeen(user)
            } else {
                // Show Toast
                view.showToastMessage()
            }
            view.hideProgressBar()
        }
    }
}