package f.fajrak.kotlin_base_project.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import f.fajrak.kotlin_base_project.view_model.BaseViewModel

abstract class BaseActivity<E : ViewDataBinding, T : BaseViewModel> : AppCompatActivity(), LifecycleOwner {

    lateinit var binding : E
    lateinit var viewModel: T

    abstract fun inject()

    abstract fun getClassViewModel(): Class<T>

    abstract fun getActivityLayoutId() : Int

    abstract fun getViewModelFactory() : ViewModelProvider.Factory


    abstract fun initUi()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inject()

        binding = DataBindingUtil.setContentView(this,getActivityLayoutId())

        viewModel = ViewModelProvider(this,getViewModelFactory()).get(getClassViewModel())

        lifecycle.addObserver(viewModel)

        initUi()

    }

}