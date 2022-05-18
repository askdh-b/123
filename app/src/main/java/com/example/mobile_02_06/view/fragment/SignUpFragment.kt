package com.example.mobile_02_06.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_02_06.R
import com.example.mobile_02_06.model.models.User
import com.example.mobile_02_06.view.activity.replace
import com.example.mobile_02_06.viewmodel.fragment.signup.SignUpViewModel
import com.example.mobile_02_06.viewmodel.fragment.signup.SignUpViewModelFactory
import java.util.*

class SignUpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val viewModel = ViewModelProvider(this, SignUpViewModelFactory(requireContext()))[SignUpViewModel::class.java]

        val etEmail: EditText = view.findViewById(R.id.etEmail)
        val etUser: EditText = view.findViewById(R.id.etUser)
        val etPassword: EditText = view.findViewById(R.id.etPassword)
        val bNewResident: EditText = view.findViewById(R.id.bNewResident)
        val bEnterYourHouse: EditText = view.findViewById(R.id.bEnterYourHouse)

        val uuid = UUID.randomUUID()

        bNewResident.setOnClickListener {
            viewModel.register(User(
                email = etEmail.text.toString(),
                name = etUser.text.toString(),
                password = etPassword.text.toString(),
                uuid = uuid.toString()
            ))
        }

        bEnterYourHouse.setOnClickListener {
            replace(requireContext(), SignInFragment())
        }

        return view
    }
}