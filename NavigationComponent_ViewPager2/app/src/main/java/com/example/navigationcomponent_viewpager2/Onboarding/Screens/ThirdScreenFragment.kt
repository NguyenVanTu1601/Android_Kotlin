package com.example.navigationcomponent_viewpager2.Onboarding.Screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.navigationcomponent_viewpager2.R
import com.example.navigationcomponent_viewpager2.databinding.FragmentThirdScreenBinding

class ThirdScreenFragment : Fragment() {


    private var _binding : FragmentThirdScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdScreenBinding.inflate(inflater, container, false)

        // ấn finish thì chuyển sang home activity
        binding.txtNextThird.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)

            onBoardingDone()
        }

        return binding.root
    }

    // Hàm check xem ngdung đã click xem hết các onBoarding chưa
    private fun onBoardingDone(){
        var sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        var editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}