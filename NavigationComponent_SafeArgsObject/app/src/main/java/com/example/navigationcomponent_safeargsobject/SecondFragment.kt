package com.example.navigationcomponent_safeargsobject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponent_safeargsobject.R
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {

    private val args by navArgs<SecondFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_second, container, false)

        view.textView2.text = "First Name : ${args.currentUser.firstName} \nLast Name : ${args.currentUser.lastName}"

        return view
    }

}