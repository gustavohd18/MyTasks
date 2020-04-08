package com.example.mytasks.Login

class LoginContract {
    interface View {
        // hide password just don't show
        fun hidePassword()

        // show alert dialog if login failed
        fun showDialogError()

        // is ok with create account
        fun showToastBar()

        // error created account
        fun showDialogErrorCreated()
    }

    interface Presenter {
        // pressed button to go main screen valid that
        fun loginButtonClicked(email: String, password: String)

        //pressed button to go create screen
        fun createAccountClicked()

        //forget password pressed
        fun forgetPasswordClicked()
    }

    interface Interactor {
        // handle with request login
        fun loginUser(user: String, password: String)

        // handle with create account
        fun createAccount(user: String, password: String)

        // handle with forget password
        fun forgetPassword(user: String)
    }

    interface InteractorOutput {
        // result request login
        fun loginUserResult(result: Boolean)

        // result request create
        fun CreateResult(result: Boolean)

        // result request forget password
        fun forgetPasswordResult(result: Boolean)
    }

    interface Router {
        // route to forget screen
        fun showForgetPassword()

        // route to screen to show new password
        fun showNewPassword()

        //return to back screen
        fun goBack()

        // go to create account
        fun showCreateAccount()

        // go to main screen
        fun showMain()

    }
}