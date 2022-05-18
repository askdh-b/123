package com.example.mobile_02_06.viewmodel.fragment.signin

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_02_06.model.network.API
import com.example.mobile_02_06.model.repository.AuthRepositoryImpl
import com.example.mobile_02_06.view.activity.LoginActivity
import kotlinx.coroutines.Dispatchers

class SignInViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val service = API.mInstance.mSettings
    private val dispatcher = Dispatchers.IO
    private val fragmentManager = (context as LoginActivity).supportFragmentManager
    private val authRepository by lazy {
        AuthRepositoryImpl(service, dispatcher)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = SignInViewModel(authRepository, fragmentManager) as T
}