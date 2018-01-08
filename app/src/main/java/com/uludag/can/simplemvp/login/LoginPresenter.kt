package com.uludag.can.simplemvp.login

import com.uludag.can.simplemvp.models.User
import org.jetbrains.annotations.Nullable

class LoginPresenter(private val model: LoginContract.Model) : LoginContract.Presenter {

    @Nullable private lateinit var mView: LoginContract.View
    //private var mModel: LoginContract.Model = model

    override fun setView(view: LoginContract.View) {
        mView = view
    }

    override fun loginButtonClicked() {
        if (mView.getFirstName().trim() == "" || mView.getLastName().trim() == "") {
            mView.showInputError()
        } else {
            model.createUser(123, mView.getFirstName(), mView.getLastName())
            mView.showUserSavedMessage()
        }
    }

    override fun getCurrentUser() {
        val user: User? = model.getUser()

        if (user == null) {
            mView.showUserNotAvailable()

        } else {
            mView.setFirstName(user.firstName)
            mView.setLastName(user.lastName)
        }
    }

}