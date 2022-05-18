package com.example.mobile_02_06.viewmodel.fragment.signin

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobile_02_06.model.models.AuthData
import com.example.mobile_02_06.model.models.Mobile
import com.example.mobile_02_06.view.ErrorDialog
import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.network.models.App
import com.example.mobile_02_06.model.repository.AppRepository
import com.example.mobile_02_06.model.repository.AuthRepository
import com.example.mobile_02_06.model.repository.MobileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class SignInViewModel(
    private val appRepository: AppRepository,
    private val mobileRepository: MobileRepository,
    private val authRepository: AuthRepository,
    private val fragmentManager: FragmentManager
) : ViewModel() {

    fun login(authData: AuthData) = GlobalScope.launch(Dispatchers.IO) {
        if (authData.email != "" && authData.password != "") {
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
                                    uuid = authData.uuid,
                                    appId = response2.value[response2.value.size - 1].appId,
                                    device = android.os.Build.DEVICE
                                )
                            )) {
                                is ResultWrapper.Success -> {
                                    when (val response4 =
                                        mobileRepository.getMobile(response2.value[response2.value.size - 1].appId)) {
                                        is ResultWrapper.Success -> {
                                            when (val response5 = authRepository.login(
                                                AuthData(
                                                    email = authData.email,
                                                    password = authData.password,
                                                    uuid = response4.value[response4.value.size - 1].uuid
                                                )
                                            )) {
                                                is ResultWrapper.Success -> {

                                                }
                                                is ResultWrapper.NetworkError -> showDialog("Ошибка с сетью. Попробуйте позже")
                                                is ResultWrapper.GenericError -> showDialog(
                                                    response5.error?.message ?: "Неизвестная ошибка"
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