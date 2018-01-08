package com.uludag.can.simplemvp.login

import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun provideLoginPresenter(model: LoginContract.Model): LoginContract.Presenter {
        return LoginPresenter(model)
    }

    @Provides
    fun provideLoginModel(repository: LoginRepository): LoginContract.Model {
        return LoginModel(repository)
    }

    // It can be a remote repository or a local database something like that...
    @Provides
    fun provideLoginRepository(): LoginRepository {
        return MemoryRepository()
    }

}