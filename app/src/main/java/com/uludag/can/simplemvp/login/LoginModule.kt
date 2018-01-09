package com.uludag.can.simplemvp.login

import android.content.SharedPreferences
import com.uludag.can.simplemvp.root.ApplicationModule
import dagger.Module
import dagger.Provides

@Module(includes = [ApplicationModule::class])
class LoginModule {

    @Provides
    fun provideLoginPresenter(model: LoginContract.Model): LoginContract.Presenter = LoginPresenter(model)

    @Provides
    fun provideLoginModel(repository: LoginRepository): LoginContract.Model = LoginModel(repository)

    // It can be a remote repository or a local database something like that...
    @Provides
    fun provideLoginRepository(sharedPrefs: SharedPreferences
                               , editor: SharedPreferences.Editor): LoginRepository
            = SharedPrefsRepository(sharedPrefs, editor)

}