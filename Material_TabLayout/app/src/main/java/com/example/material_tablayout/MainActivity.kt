package com.example.material_tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.badge.BadgeDrawable
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Dàn đều tab sử dụng : tabmode = fixed, nếu muốn dồn về 1 góc thì dùng tabmode = scrollable
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        tablayout.setupWithViewPager(viewPager)

        var viewpagerAdapter : ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager,0)
        viewpagerAdapter.addFragment(fragment_explore(), "Explore")
        viewpagerAdapter.addFragment(fragment_flights(), "Flights")
        viewpagerAdapter.addFragment(fragment_travel(), "Travel")

        viewPager.adapter = viewpagerAdapter


        tablayout.getTabAt(0)?.setIcon(R.drawable.ic_baseline_explore_24)
        tablayout.getTabAt(1)?.setIcon(R.drawable.ic_baseline_flight_24)
        tablayout.getTabAt(2)?.setIcon(R.drawable.ic_baseline_card_travel_24)


        var badDrawble : BadgeDrawable = tablayout.getTabAt(0)?.orCreateBadge!!
        badDrawble.setVisible(true)
        badDrawble.number = 12



    }
}