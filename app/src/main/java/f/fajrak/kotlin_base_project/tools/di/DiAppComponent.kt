package f.fajrak.kotlin_base_project.tools.di

import dagger.Component
import f.fajrak.kotlin_base_project.view.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [DiAppModule::class])
abstract class DiAppComponent {
    abstract fun inject(target : MainActivity)
}