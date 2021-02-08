package com.example.navigationcomponent_bottomnavigationview

import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var listener : NavController.OnDestinationChangedListener
    private lateinit var navController: NavController
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        navController = findNavController(R.id.fragment)

        //setup app bar change name with fragment
        val appBarConfiguration  = AppBarConfiguration(setOf(R.id.firstFragment,R.id.secondFragment,R.id.thirdFragment))
        setupActionBarWithNavController(navController,appBarConfiguration)

        // set up bottom appbar
        bottomNavigationView.setupWithNavController(navController)

        // lắng nghe sự kiện đang chọn fragment nào để đổi màu actionBar cùng màu background
        listener = NavController.OnDestinationChangedListener{ controller, destination, arguments ->
            if (destination.id == R.id.firstFragment){
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_500)))
            }
            else if (destination.id == R.id.secondFragment){
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.teal_200)))
            }
            else if (destination.id == R.id.thirdFragment){
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_200)))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        super.onPause()
        navController.addOnDestinationChangedListener(listener)
    }
}