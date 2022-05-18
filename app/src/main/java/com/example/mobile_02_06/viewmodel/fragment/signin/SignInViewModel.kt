package com.example.mobile_02_06.viewmodel.fragment.signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobile_02_06.model.models.AuthData
import com.example.mobile_02_06.model.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignInViewModel(private val authRepository: AuthRepository) :ViewModel() {

    val authData = MutableLiveData<AuthData>()

    private fun login() = GlobalScope.launch(Dispatchers.IO) {
        when (val response = authRepository.login(authData.postValue(authData))) {
            is Result.Success -> {

            }
            is Result.NetworkError -> {

            }
            is Result.Error -> {

            }
        }
    }

    private fun showDialog(message: String) {

    }
}