package com.odds.movie.login

import kotlinx.coroutines.Dispatchers
import org.junit.Assert.*
import org.junit.Test

class LoginPresenterTest {
    @Test
    fun `when input username and password correct should call goToMovieScreen`() {

        // AAA = Arrange, Act, Assert
        // Arrange = Given a context, prepare environment or object
        val presenter = LoginPresenter(Dispatchers.Unconfined, 0)
        val view = SpyLoginView()
        presenter.attachView(view)

        // Act = Action, Behavior
        presenter.login("admin", "admin")

        //Assert = Verify the result
        val expect = 1
        val expectShowToastMessage = 0
        assertEquals(expect, view.spyGoToMovieScreen)
        assertEquals(expectShowToastMessage, view.spyShowToastMessage)

        //Test Double = Spy, Mock, Dummy, Fake, Stub
        //Mock, Stub
        //Spy

    }

    @Test
    fun `when input username and password incorrect should call showToastMessage`() {
        //Arrange
        val presenter= LoginPresenter(Dispatchers.Unconfined, 0)
        val  view = SpyLoginView()
        presenter.attachView(view)

        //Act
        presenter.login("user ผิด","password ผิด")

        //Assert = Verify the result
        val expect = 1
        assertEquals(expect, view.spyShowToastMessage)

    }

    class SpyLoginView : LoginPresenter.LoginView {

        var spyGoToMovieScreen = 0
        var spyShowToastMessage = 0

        override fun goToMovieScreeen(user: User) {
            spyGoToMovieScreen += 1
        }

        override fun showToastMessage() {
            spyShowToastMessage += 1
        }

        override fun showProgressBar() {

        }

        override fun hideProgressBar() {

        }

    }
}