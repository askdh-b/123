package com.example.mobile_02_06.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_02_06.R
import com.example.mobile_02_06.viewmodel.fragment.signin.SignInViewModel
import com.example.mobile_02_06.viewmodel.fragment.signin.SignViewModelFactory

class SignInFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        val viewModel = ViewModelProvider(this, SignViewModelFactory(requireActivity()))[SignInViewModel::class.java]

        val etEmail: EditText = view.findViewById(R.id.etEmail)
        val etPassword: EditText = view.findViewById(R.id.etPassword)
        val bEnterYourHome: Button = view.findViewById(R.id.bEnterYourHouse)
        val bNewResident: Button = view.findViewById(R.id.bNewResident)

        bEnterYourHome.setOnClickListener {

        }

        bNewResident.setOnClickListener {

        }

        return view
    }
}