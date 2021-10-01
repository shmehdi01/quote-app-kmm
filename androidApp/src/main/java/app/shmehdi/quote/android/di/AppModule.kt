package app.shmehdi.quote.android.di

import android.app.Application
import app.shmehdi.quote.utils.preference.AppPreference
import app.shmehdi.quote.utils.preference.AppPreferenceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideSharePref(application: Application) : AppPreference = AppPreferenceImpl(application)
}