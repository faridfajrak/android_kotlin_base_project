package f.fajrak.kotlin_base_project.view

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import f.fajrak.kotlin_base_project.R
import f.fajrak.kotlin_base_project.databinding.BindingMainActivity
import f.fajrak.kotlin_base_project.tools.di.DaggerDiAppComponent
import f.fajrak.kotlin_base_project.tools.di.DiAppComponent
import f.fajrak.kotlin_base_project.tools.di.DiAppModule
import f.fajrak.kotlin_base_project.tools.repository.ApiService
import f.fajrak.kotlin_base_project.view_model.MainActivityViewModel
import javax.inject.Inject

class MainActivity : BaseActivity<BindingMainActivity,MainActivityViewModel>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Inject
    lateinit var sharedPreferences: SharedPreferences
    @Inject
    lateinit var apiService: ApiService

    override fun inject() {
        DaggerDiAppComponent.builder()
            .diAppModule(DiAppModule(context = this))
            .build()
            .inject(this)

    }

    override fun getClassViewModel(): Class<MainActivityViewModel> = MainActivityViewModel::class.java

    override fun getActivityLayoutId(): Int = R.layout.activity_main

    override fun getViewModelFactory(): ViewModelProvider.Factory =MainActivityViewModel.Factory(sharedPreferences,apiService)

    override fun initUi() {
        binding.mainText = "This Project Illustrates MVVM architecture with a generic approach"
    }

}