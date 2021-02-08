package com.example.imageview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contrainLayout.setBackgroundColor(Color.GRAY)
        imageView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                imageView.setImageResource(R.drawable.image7)
            }

        })
    }
}