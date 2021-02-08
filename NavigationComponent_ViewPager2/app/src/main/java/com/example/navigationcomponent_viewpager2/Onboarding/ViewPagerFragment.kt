package com.example.navigationcomponent_viewpager2.Onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationcomponent_viewpager2.Onboarding.Screens.FirstScreenFragment
import com.example.navigationcomponent_viewpager2.Onboarding.Screens.SecondScreenFragment
import com.example.navigationcomponent_viewpager2.Onboarding.Screens.ThirdScreenFragment
import com.example.navigationcomponent_viewpager2.R
import com.example.navigationcomponent_viewpager2.databinding.FragmentViewPagerBinding


class ViewPagerFragment : Fragment() {

    private var _binding : FragmentViewPagerBinding? = null;
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)

        var fragmentList = arrayListOf<Fragment>(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager2.adapter = adapter
        return binding.root
    }

}