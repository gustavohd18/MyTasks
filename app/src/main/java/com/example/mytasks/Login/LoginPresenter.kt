package com.example.mytasks.Login

class LoginPresenter(
    val view: LoginContract.View?,
    var interactor: LoginContract.Interactor?,
    var router: LoginContract.Router?
) :
    LoginContract.Presenter,
    LoginContract.InteractorOutput {
    override fun loginButtonClicked(email: String, password: String) {
        interactor?.loginUser(email, password)
    }

    override fun createAccountClicked() {
        router?.showCreateAccount()
    }

    override fun forgetPasswordClicked() {
        router?.showForgetPassword()
    }

    override fun loginUserResult(result: Boolean) {
        if (result) {
            router?.showMain()
        } else {
            view?.showDialogError()
        }
    }

    override fun CreateResult(result: Boolean) {

        if (result) {
            view?.showToastBar()
            router?.showMain()
        } else {
            view?.showDialogErrorCreated()
        }
    }

    override fun forgetPasswordResult(result: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}