package com.example.material_tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {

    var listFm : ArrayList<Fragment>? = ArrayList<Fragment>()
    var listTitle : ArrayList<String>? = ArrayList<String>()

    fun addFragment(fr : Fragment, title : String){
        listFm?.add(fr)
        listTitle?.add(title)
    }
    override fun getItem(position: Int): Fragment {
        return listFm?.get(position)!!
    }

    override fun getCount(): Int {
        return listFm?.size!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return listTitle?.get(position)!!
    }
}