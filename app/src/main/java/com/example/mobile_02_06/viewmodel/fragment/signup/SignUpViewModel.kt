package com.example.mobile_02_06.viewmodel.fragment.signup

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.example.mobile_02_06.model.models.User
import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.repository.UserRepository
import com.example.mobile_02_06.view.ErrorDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val userRepository: UserRepository,
    private val fragmentManager: FragmentManager
) : ViewModel() {
    fun register(user: User) = GlobalScope.launch(Dispatchers.IO) {
        if (user.email != "" && user.name != "" && user.password != "") {
            when (val response = userRepository.register(
                User(
                    email = user.email,
                    name = user.name,
                    password = user.password,
                    uuid = user.uuid
                )
            )) {
                is ResultWrapper.Success -> {

                }
                is ResultWrapper.NetworkError -> showDialog("Ошибка с сетью. Попробуйте позже")
                is ResultWrapper.GenericError -> showDialog(
                    response.error?.message ?: "Неизвестная ошибка"
                )
            }
        } else showDialog("Заполните все поля")
    }

    private fun showDialog(message: String) {
        val errorDialog = ErrorDialog(message)
        val manager = fragmentManager
        errorDialog.show(manager, "")
    }
}