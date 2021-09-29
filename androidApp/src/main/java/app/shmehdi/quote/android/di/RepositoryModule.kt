package app.shmehdi.quote.android.di

import android.app.Application
import app.shmehdi.quote.repository.AuthRepository
import app.shmehdi.quote.utils.preference.AppPreference
import app.shmehdi.quote.utils.preference.AppPreferenceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun provideAuthRepository() = AuthRepository()

    @Provides
    fun provideSharePref(application: Application) : AppPreference = AppPreferenceImpl(application)
}