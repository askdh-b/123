package com.example.mobile_02_06.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_02_06.R
import com.example.mobile_02_06.viewmodel.fragment.StaticsViewModel

class StaticsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this)[StaticsViewModel::class.java]

        val view = inflater.inflate(R.layout.fragment_statics, container, false)

        return view
    }
}