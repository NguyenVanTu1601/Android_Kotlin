package com.example.navigationcomponent_viewpager2.Onboarding.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.navigationcomponent_viewpager2.R
import com.example.navigationcomponent_viewpager2.databinding.FragmentFirstScreenBinding

class FirstScreenFragment : Fragment() {

    private var _binding : FragmentFirstScreenBinding? = null;
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentFirstScreenBinding.inflate(inflater, container, false )


        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager2)

        binding.txtNextFirst.setOnClickListener {
            viewPager?.currentItem = 1 // do cái first có curent = 0 nên ấn tại first chuyển sang second thì phải set curren = 1
        }

        return binding.root
    }

}