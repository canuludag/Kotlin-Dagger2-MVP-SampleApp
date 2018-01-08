package com.uludag.can.simplemvp.root

import android.app.Application
import com.uludag.can.simplemvp.login.LoginModule

class App: Application() {

    lateinit var mApplicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        // Initialize Dagger graph
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .loginModule(LoginModule())
                .build()
    }

}