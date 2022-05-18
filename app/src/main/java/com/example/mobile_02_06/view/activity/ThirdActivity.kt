package com.example.mobile_02_06.view.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mobile_02_06.R
import com.example.mobile_02_06.view.fragment.AddRoomFragment

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        supportActionBar?.hide()

        replace3(this, AddRoomFragment())
    }
}

fun replace3(context: Context, fragment: Fragment) {
    val ft = (context as ThirdActivity).supportFragmentManager.beginTransaction()
    ft.replace(R.id.fcvContent3, fragment)
    ft.commit()
}