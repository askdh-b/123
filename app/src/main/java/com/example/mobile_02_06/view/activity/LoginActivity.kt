package com.example.mobile_02_06.view.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_02_06.R
import com.example.mobile_02_06.view.fragment.SignInFragment
import com.example.mobile_02_06.viewmodel.activity.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        replace(this, SignInFragment())
    }
}

fun replace(context: Context, fragment: Fragment) {
    val ft = (context as MainActivity).supportFragmentManager.beginTransaction()
    ft.replace(R.id.fcvLogin, fragment)
    ft.commit()
}