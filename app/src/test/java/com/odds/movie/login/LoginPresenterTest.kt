package com.odds.movie.login

import kotlinx.coroutines.Dispatchers
import org.junit.Assert.*
import org.junit.Test

class LoginPresenterTest {
    @Test
    fun `when input username and password correct should call goToMovie`() {

        // AAA = Arrange, Act, Assert
        // Arrange = Given a context, prepare environment or object
        val presenter = LoginPresenter(Dispatchers.Unconfined, 0)
        val view = SpyLoginView()
        presenter.attachView(view)

        // Act = Action, Behavior
        presenter.login("admin", "admin")

        //Assert = Verify the result
        val expect = 1
        assertEquals(expect, view.spyGoToMovieScreen)

        //Test Double = Spy, Mock, Dummy, Fake, Stub
        //Mock, Stub
        //Spy

    }

    class SpyLoginView : LoginPresenter.LoginView {

        var spyGoToMovieScreen = 0

        override fun goToMovieScreeen(user: User) {
            spyGoToMovieScreen += 1
        }

        override fun showToastMessage() {

        }

        override fun showProgressBar() {

        }

        override fun hideProgressBar() {

        }

    }
}