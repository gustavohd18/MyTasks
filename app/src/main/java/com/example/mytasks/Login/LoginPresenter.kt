package com.example.mytasks.Login

class LoginPresenter(val view: LoginContract.View?, var interactor: LoginContract.Interactor?) :
    LoginContract.Presenter,
    LoginContract.InteractorOutput {
    override fun loginButtonClicked(email: String, password: String) {
        interactor?.loginUser(email, password)
    }

    override fun createAccountClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun forgetPasswordClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginUserResult(result: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun CreateResult(result: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun forgetPasswordResult(result: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}