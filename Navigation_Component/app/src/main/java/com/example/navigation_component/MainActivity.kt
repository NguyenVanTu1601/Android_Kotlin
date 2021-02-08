package com.example.navigation_component

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // private lateinit var navHostFragment : NavHostFragment // làm theo document

    private lateinit var navController : NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var listener : NavController.OnDestinationChangedListener

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment // học theo document
//        navController = navHostFragment.navController
//        findViewById<NavigationView>(R.id.navigationView).setupWithNavController(navController)

        navController = findNavController(R.id.fragment)
        drawerLayout = findViewById(R.id.drawer_layout)

        // set up navigation controller
        navigationView.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        // setup actionBar with navigation view
        setupActionBarWithNavController(navController, appBarConfiguration)

        // lắng nghe sự kiện đang chọn fragment nào để đổi màu actionBar cùng màu background
        listener = NavController.OnDestinationChangedListener{ controller, destination, arguments ->
            if (destination.id == R.id.firstFragment){
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.teal_200)))
            }else if (destination.id == R.id.secondFragment){
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_500)))
            }
        }
    }

    // đóng mở navigation drawer
    override fun onSupportNavigateUp(): Boolean {
        var navController = findNavController(R.id.fragment)
        return  navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
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