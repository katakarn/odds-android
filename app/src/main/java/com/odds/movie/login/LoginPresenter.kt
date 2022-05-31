package com.odds.movie.login

class LoginPresenter {

    //loose coupling, hight cohesion ข้อต่อหลวม, ความสามัคคีสูง
    private lateinit var view: LoginView

    fun attachView(view:LoginView){
        this.view = view
    }

    interface LoginView {
        fun goToMovieScreeen(user: User)
        fun showToastMessage()
    }

    fun login(username: String, password: String) {
        if (username == "admin" && password == "admin") {
            //navigate to Movie Activity
            val user = User(username, password)
            view.goToMovieScreeen(user)
        } else {
            // Show Toast
            view.showToastMessage()
        }
    }
}