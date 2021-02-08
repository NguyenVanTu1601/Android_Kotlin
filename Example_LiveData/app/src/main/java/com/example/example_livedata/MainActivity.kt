package com.example.example_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewModel  = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.seconds().observe(this, Observer { it ->
            text_number.text = it.toString();
        })

        viewModel.finished.observe(this, Observer {
            if (it){
                Toast.makeText(this, "Hết giờ...", Toast.LENGTH_SHORT).show();
            }
        })

        btn_start.setOnClickListener {
            if (edt_time.text.isEmpty() || edt_time.text.length < 4){
                Toast.makeText(this, "Invalid number...",Toast.LENGTH_SHORT).show();
            }else{
                viewModel.timeValue.value = edt_time.text.toString().toLong()
                viewModel.startTimer()
            }

        }

        btn_stop.setOnClickListener {
            text_number.text = "0"
            viewModel.stopTimer()
        }
    }
}