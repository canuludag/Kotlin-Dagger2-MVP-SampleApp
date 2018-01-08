package com.uludag.can.simplemvp.root

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val mApp: App) {
    @Provides
    @Singleton
    fun provideContext(): Context {
        return mApp.applicationContext
    }
}