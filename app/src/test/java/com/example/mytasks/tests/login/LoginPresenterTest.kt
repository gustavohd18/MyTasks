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

    private val presenter = LoginPresenter(view, interactor, router)

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

    @Test
    fun `should call route to createAccount`() {
        //when
        presenter.createAccountClicked()

        //then
        verify(router).showCreateAccount()
    }

    @Test
    fun `should call route to forget password`() {
        //when
        presenter.forgetPasswordClicked()

        //then
        verify(router).showForgetPassword()
    }

    @Test
    fun `Handle with login result true should go to main screen`() {
        //give
        val result = true
        //when
        presenter.loginUserResult(result)

        //then
        verify(router).showMain()
    }

    @Test
    fun `Handle with login result true should show alert dialog`() {
        //give
        val result = false
        //when
        presenter.loginUserResult(result)

        //then
        verify(view).showDialogError()
    }

    @Test
    fun `Handle with create result false should call view error`() {
        //give
        val result = false
        //when
        presenter.CreateResult(result)

        //then
        verify(view).showDialogErrorCreated()
    }

    @Test
    fun `Handle with create result true should call view result and router`() {
        //give
        val result = true
        //when
        presenter.CreateResult(result)

        //then
        verify(view).showToastBar()
        verify(router).showMain()
    }
}