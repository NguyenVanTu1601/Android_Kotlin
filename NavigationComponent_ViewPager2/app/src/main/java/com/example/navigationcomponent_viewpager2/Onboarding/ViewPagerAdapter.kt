package com.example.navigationcomponent_viewpager2.Onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
        list : ArrayList<Fragment>,
        fm : FragmentManager,
        lifecycle : Lifecycle
) : FragmentStateAdapter(fm,lifecycle) {

    val fragentList = list
    override fun getItemCount(): Int {
        return fragentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragentList.get(position)
    }
}