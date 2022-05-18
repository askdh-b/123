package com.example.mobile_02_06.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.mobile_02_06.R
import com.example.mobile_02_06.view.activity.ThirdActivity

class AddRoomFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_add_room, container, false)

        val back: ImageView = view.findViewById(R.id.ivBack)

        back.setOnClickListener {
            (activity as ThirdActivity).finish()
        }

        return view
    }
}