package com.example.mobile_02_06.viewmodel.fragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_02_06.model.network.API
import com.example.mobile_02_06.model.repository.RoomRepositoryImpl
import com.example.mobile_02_06.view.activity.MainActivity
import kotlinx.coroutines.Dispatchers

class HomeViewModelFactory(context: Context): ViewModelProvider.Factory {
    private val service = API.mInstance.mSettings
    private val dispatcher = Dispatchers.IO
    private val fragmentManager = (context as MainActivity).supportFragmentManager
    private val roomRepository by lazy {
        RoomRepositoryImpl(service, dispatcher)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T = HomeViewModel(roomRepository, fragmentManager) as T
}