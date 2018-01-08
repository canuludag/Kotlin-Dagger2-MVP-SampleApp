package com.uludag.can.simplemvp.login

import com.uludag.can.simplemvp.models.User

class LoginModel(private val repository: LoginRepository): LoginContract.Model {
    override fun createUser(id: Int, firstName: String, lastName: String) {
        repository.saveUser(User(id, firstName, lastName))
    }

    override fun getUser(): User? {
        return repository.getUser()
    }

}