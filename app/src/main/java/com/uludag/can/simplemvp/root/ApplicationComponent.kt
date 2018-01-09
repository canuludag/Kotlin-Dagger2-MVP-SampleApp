package com.uludag.can.simplemvp.root

import com.uludag.can.simplemvp.login.LoginActivity
import com.uludag.can.simplemvp.login.LoginModule
import com.uludag.can.simplemvp.login.SharedPrefsRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class), (LoginModule::class)])
interface ApplicationComponent {
    fun inject(target: LoginActivity)
    fun inject(target: SharedPrefsRepository)
}