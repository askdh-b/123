package com.example.mobile_02_06.viewmodel.fragment

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobile_02_06.model.models.AuthData
import com.example.mobile_02_06.model.models.Token
import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.repository.RoomRepository
import com.example.mobile_02_06.view.ErrorDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel(private val roomRepository: RoomRepository, private val fragmentManager: FragmentManager) : ViewModel() {

    fun getRooms(token: Token) = GlobalScope.launch(Dispatchers.IO) {
        when (val response = roomRepository.get(
            Token(
                token = token.token,
                uuid = token.uuid
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

    private fun showDialog(message: String) {
        val errorDialog = ErrorDialog(message)
        val manager = fragmentManager
        errorDialog.show(manager, "")
    }
}