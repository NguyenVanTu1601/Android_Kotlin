package com.example.example_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewModel : CountNumberViewModel = ViewModelProvider(this).get(CountNumberViewModel::class.java)
        textNumber.text = viewModel.number.toString()
        btn_add.setOnClickListener {
            viewModel.addNumber()
            textNumber.text = viewModel.number.toString()
        }
    }
}