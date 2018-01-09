package com.uludag.can.simplemvp.root

import android.content.Context
import android.content.SharedPreferences
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

    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context): SharedPreferences = context
            .getSharedPreferences("REPOSITORY_PREFS", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun providePrefsEditor(sharedPreferences: SharedPreferences): SharedPreferences.Editor = sharedPreferences.edit()

}