package com.example.deviceinfo

import android.app.ActionBar
import android.content.ClipDescription
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock.uptimeMillis
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_general.*
import java.util.concurrent.TimeUnit
import java.lang.System.getProperties
import java.lang.System.getProperty

class GeneralActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general)

        var actionBar : androidx.appcompat.app.ActionBar? = supportActionBar
        if (actionBar != null){
            actionBar.title = "General Info"
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        // canculating device up time
        var miliSec : Long = uptimeMillis()
        var upTime : String = String.format("%02d : %02d : %02d",
            TimeUnit.MILLISECONDS.toHours(miliSec),
            TimeUnit.MILLISECONDS.toMinutes(miliSec) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(miliSec)),
            TimeUnit.MILLISECONDS.toSeconds(miliSec) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(miliSec)))

        // array of containing infomation
        var titles : ArrayList<String> = arrayListOf("Model","Manufacturer", "Device", "Board", "Hardware", "Brand", "Android Version",
                                                    "OS Name" , "API Lever","BootLoader", "Build Version", "Build Number", "Radio Version",
                                                    "Kernal", "Android Runtime", "Up Time")
        var descriptions : ArrayList<String> = arrayListOf(Build.MODEL, Build.MANUFACTURER, Build.DEVICE, Build.BOARD, Build.HARDWARE, Build.BRAND,
        Build.VERSION.RELEASE, "null", Build.VERSION.SDK_INT.toString(), Build.BOOTLOADER, Build.FINGERPRINT, "null", Build.getRadioVersion(),
            "null","null", upTime)

        var adapter : GeneralAdapter = GeneralAdapter(this,titles,descriptions)
        generalList.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}