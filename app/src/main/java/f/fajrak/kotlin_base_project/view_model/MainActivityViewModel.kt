package f.fajrak.kotlin_base_project.view_model

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import f.fajrak.kotlin_base_project.tools.repository.ApiService

class MainActivityViewModel(val sharedPreferences: SharedPreferences, val apiService: ApiService) : BaseViewModel(){

    class Factory(val sharedPreferences: SharedPreferences,val apiService: ApiService) : ViewModelProvider.Factory
    {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainActivityViewModel(sharedPreferences,apiService) as T
        }
    }



}