package com.uludag.can.simplemvp.login

import com.uludag.can.simplemvp.models.User

interface LoginRepository {
    fun getUser(): User?
    fun saveUser(user: User)
}