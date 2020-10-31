package f.fajrak.kotlin_base_project.tools.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import f.fajrak.kotlin_base_project.BuildConfig
import f.fajrak.kotlin_base_project.tools.repository.ApiService
import javax.inject.Singleton

@Module
class DiAppModule(val context : Context)
{
    @Provides
    @Singleton
    fun provideApiService() : ApiService{
        return  ApiService.create()
    }

    @Provides
    @Singleton
    fun provideSharedPreference() : SharedPreferences{
        return  context.getSharedPreferences(BuildConfig.shared_pref_name,Context.MODE_PRIVATE)
    }

}