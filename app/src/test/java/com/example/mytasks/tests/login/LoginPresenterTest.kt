package com.example.mytasks.tests.login

import com.example.mytasks.Login.LoginContract
import com.example.mytasks.Login.LoginPresenter

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class LoginPresenterTest {
    private val view: LoginContract.View = mock()
    private val interactor: LoginContract.Interactor = mock()
    private val router: LoginContract.Router = mock()

    private val presenter = LoginPresenter(view, interactor)

    @Test
    fun `should call valid user login`() {
        // give
        val email = "teste@gmail.com"
        val password = "12345"

        //when
        presenter.loginButtonClicked(email, password)

        //then
        verify(interactor).loginUser(email, password)
    }
}