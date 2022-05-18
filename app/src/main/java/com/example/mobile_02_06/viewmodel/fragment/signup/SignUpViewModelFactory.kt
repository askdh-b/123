package com.example.mobile_02_06.viewmodel.fragment.signup

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_02_06.model.network.API
import com.example.mobile_02_06.model.repository.AppRepositoryImpl
import com.example.mobile_02_06.model.repository.MobileRepositoryImpl
import com.example.mobile_02_06.model.repository.UserRepositoryImpl
import com.example.mobile_02_06.view.activity.LoginActivity
import kotlinx.coroutines.Dispatchers

class SignUpViewModelFactory(context: Context) : ViewModelProvider.Factory{
    private val service = API.mInstance.mSettings
    private val dispatcher = Dispatchers.IO
    private val fragmentManager = (context as LoginActivity).supportFragmentManager
    private val userRepository by lazy {
        UserRepositoryImpl(service, dispatcher)
    }
    private val appRepository by lazy {
        AppRepositoryImpl(service, dispatcher)
    }
    private val mobileRepository by lazy {
        MobileRepositoryImpl(service, dispatcher)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T = SignUpViewModel(appRepository, mobileRepository, userRepository, fragmentManager) as T
}