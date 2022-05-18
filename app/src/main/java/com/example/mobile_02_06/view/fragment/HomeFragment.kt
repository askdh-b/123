package com.example.mobile_02_06.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_02_06.R
import com.example.mobile_02_06.view.activity.ThirdActivity
import com.example.mobile_02_06.view.activity.replace3
import com.example.mobile_02_06.viewmodel.fragment.HomeViewModel
import com.example.mobile_02_06.viewmodel.fragment.HomeViewModelFactory

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this, HomeViewModelFactory(requireContext()))[HomeViewModel::class.java]

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val bAddRoom: ImageView = view.findViewById(R.id.ivAddRoom)

        bAddRoom.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdActivity::class.java))
        }

        return view
    }
}