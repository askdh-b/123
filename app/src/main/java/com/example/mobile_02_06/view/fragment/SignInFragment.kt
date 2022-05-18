package com.example.mobile_02_06.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_02_06.R
import com.example.mobile_02_06.model.models.AuthData
import com.example.mobile_02_06.view.activity.MainActivity
import com.example.mobile_02_06.view.activity.replace
import com.example.mobile_02_06.viewmodel.fragment.signin.SignInViewModel
import com.example.mobile_02_06.viewmodel.fragment.signin.SignInViewModelFactory
import java.util.*

class SignInFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        val viewModel = ViewModelProvider(
            this,
            SignInViewModelFactory(requireActivity())
        )[SignInViewModel::class.java]

        val etEmail: EditText = view.findViewById(R.id.etEmail)
        val etPassword: EditText = view.findViewById(R.id.etPassword)
        val bEnterYourHome: Button = view.findViewById(R.id.bEnterYourHouse)
        val bNewResident: Button = view.findViewById(R.id.bNewResident)

        val uuid = UUID.randomUUID()

        bEnterYourHome.setOnClickListener {
            viewModel.login(
                AuthData(
                    etEmail.text.toString(),
                    etPassword.text.toString(),
                    uuid.toString()
                )
            )
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

        bNewResident.setOnClickListener {
            replace(requireContext(), SignUpFragment())
        }

        return view
    }
}