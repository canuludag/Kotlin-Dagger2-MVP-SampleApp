package com.uludag.can.simplemvp.login

import com.uludag.can.simplemvp.models.User

interface LoginContract {
    interface View {
        fun getFirstName(): String
        fun getLastName(): String
        fun showUserNotAvailable()
        fun showInputError()
        fun showUserSavedMessage()
        fun setFirstName(firstName: String)
        fun setLastName(lastName: String)
    }

    interface Presenter {
        fun setView(view: LoginContract.View)
        fun saveUser()
        fun getCurrentUser()
    }

    interface Model {
        fun createUser(id:Int, firstName: String, lastName: String)
        fun getUser(): User?
    }
}