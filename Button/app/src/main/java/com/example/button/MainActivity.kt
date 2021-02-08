package com.example.button

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var check : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonClick.setOnClickListener {it->
            Toast.makeText(this@MainActivity,"You clicked me", Toast.LENGTH_SHORT).show()
            if (check){
                check = false
                it.setBackgroundColor(Color.parseColor("#DB6400"))

            }else{
                check = true
                it.setBackgroundColor(Color.parseColor("#CC0E74"))

            }

        }

//        buttonClick.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                Toast.makeText(this@MainActivity,"You clicked me", Toast.LENGTH_SHORT).show()
//                if (check){
//                    check = false
//                    v?.setBackgroundColor(Color.parseColor("#DB6400"))
//
//                }else{
//                    check = true
//                    v?.setBackgroundColor(Color.parseColor("#CC0E74"))
//
//                }
//            }
//        })
    }
}