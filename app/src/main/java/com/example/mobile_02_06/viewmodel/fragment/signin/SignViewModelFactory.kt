package com.example.mobile_02_06.viewmodel.fragment.signin

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_02_06.model.repository.AuthRepositoryImpl

class SignViewModelFactory(context: Context) : ViewModelProvider.Factory {

    val authRepository by lazy {
        AuthRepositoryImpl()
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = SignInViewModel(authRepository) as T
}