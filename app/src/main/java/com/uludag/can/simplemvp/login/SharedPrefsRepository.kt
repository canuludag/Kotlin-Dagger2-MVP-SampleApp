package com.uludag.can.simplemvp.login

import android.content.SharedPreferences
import com.uludag.can.simplemvp.models.User
import javax.inject.Inject

class SharedPrefsRepository @Inject constructor(private val sharedPrefs: SharedPreferences
                                                , private val prefsEditor: SharedPreferences.Editor) : LoginRepository {

    override fun getUser(): User? = User(sharedPrefs.getInt("id", 0)
                , sharedPrefs.getString("first_name", "Albert")
                , sharedPrefs.getString("last_name", "Einstein"))

    override fun saveUser(user: User) {
        prefsEditor.putInt("id", user.id)
        prefsEditor.putString("first_name", user.firstName)
        prefsEditor.putString("last_name", user.lastName)
        prefsEditor.apply()
    }

}