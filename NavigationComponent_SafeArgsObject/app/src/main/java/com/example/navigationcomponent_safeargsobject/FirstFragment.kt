package com.example.navigationcomponent_safeargsobject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent_safeargsobject.model.User
import kotlinx.android.synthetic.main.fragment_first.view.*


class FirstFragment : Fragment() {
    private lateinit var  navController : NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        view.btn_Send.setOnClickListener {
            val firstName = view.edt_firstName.text.toString()
            val lastName = view.edt_LastName.text.toString()
            val user = User(firstName, lastName)

            var action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(user)
            findNavController().navigate(action)

        }
        return view
    }


}