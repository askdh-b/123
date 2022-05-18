package com.example.mobile_02_06.viewmodel.fragment.signin

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobile_02_06.model.models.AuthData
import com.example.mobile_02_06.view.ErrorDialog
import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignInViewModel(private val authRepository: AuthRepository, private val fragmentManager: FragmentManager) : ViewModel() {

    fun login(authData: AuthData) = GlobalScope.launch(Dispatchers.IO) {
        if (authData.email != "" && authData.password != "") {
            when (val response = authRepository.login(
                AuthData(
                    email = authData.email,
                    password = authData.password,
                    uuid = authData.uuid
                )
            )) {
                is ResultWrapper.Success -> {

                }
                is ResultWrapper.NetworkError -> showDialog("Ошибка с сетью. Попробуйте позже")
                is ResultWrapper.GenericError -> showDialog(response.error?.message ?: "Неизвестная ошибка")
            }
        } else showDialog("Заполните все поля")

    }

    private fun showDialog(message: String) {
        val errorDialog = ErrorDialog(message)
        val manager = fragmentManager
        errorDialog.show(manager, "")
    }
}