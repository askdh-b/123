package com.example.mobile_02_06.viewmodel.fragment.signup

import android.os.Build
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.example.mobile_02_06.model.models.Mobile
import com.example.mobile_02_06.model.models.User
import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.network.models.App
import com.example.mobile_02_06.model.repository.AppRepository
import com.example.mobile_02_06.model.repository.MobileRepository
import com.example.mobile_02_06.model.repository.UserRepository
import com.example.mobile_02_06.view.ErrorDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val appRepository: AppRepository,
    private val mobileRepository: MobileRepository,
    private val userRepository: UserRepository,
    private val fragmentManager: FragmentManager
) : ViewModel() {
    fun register(user: User) = GlobalScope.launch(Dispatchers.IO) {
        if (user.email != "" && user.name != "" && user.password != "") {
            when (val response = appRepository.create(
                App(
                    appId = "com.example.mobile_02_06",
                    competitor = "Competitor-6",
                )
            )) {
                is ResultWrapper.Success -> {
                    when (val response2 = appRepository.get("Competitor-6")) {
                        is ResultWrapper.Success -> {
                            when (val response3 = mobileRepository.register(
                                Mobile(
                                    uuid = user.uuid,
                                    appId = response2.value[response2.value.size - 1].appId,
                                    device = Build.DEVICE
                                )
                            )) {
                                is ResultWrapper.Success -> {
                                    when (val response4 =
                                        mobileRepository.getMobile(response2.value[response2.value.size].appId)) {
                                        is ResultWrapper.Success -> {
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
                                        }
                                        is ResultWrapper.NetworkError -> showDialog("Ошибка с сетью. Попробуйте позже")
                                        is ResultWrapper.GenericError -> showDialog(
                                            response4.error?.message ?: "Неизвестная ошибка"
                                        )
                                    }
                                }
                                is ResultWrapper.NetworkError -> showDialog("Ошибка с сетью. Попробуйте позже")
                                is ResultWrapper.GenericError -> showDialog(
                                    response3.error?.message ?: "Неизвестная ошибка"
                                )
                            }
                        }
                        is ResultWrapper.NetworkError -> showDialog("Ошибка с сетью. Попробуйте позже")
                        is ResultWrapper.GenericError -> showDialog(
                            response2.error?.message ?: "Неизвестная ошибка"
                        )
                    }
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