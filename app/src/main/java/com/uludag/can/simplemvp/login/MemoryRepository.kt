package com.uludag.can.simplemvp.login

import com.uludag.can.simplemvp.models.User

class MemoryRepository : LoginRepository {

    private lateinit var mUser: User

    override fun saveUser(user: User) {
        mUser = getUser()
    }

    override fun getUser(): User {
        return User(0, "Albert", "Einstein")
    }

}