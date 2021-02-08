package com.example.coil_convertandload_image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.load("https://www.thiennhien.net/wp-content/uploads/2020/04/240420_dadangsinhhoc.jpg"){
            placeholder(R.drawable.images) // ảnh mặc định khi chưa load xong ảnh cần từ internet
            crossfade(true)
            crossfade(1000) // hiện ảnh theo kiểu animation
            //transformations(RoundedCornersTransformation(30f)) // bo góc
            //transformations(CircleCropTransformation()) // bo tròn
            //transformations(GrayscaleTransformation()) // đen trắng
            //transformations(BlurTransformation(applicationContext, 20f)) // làm nhòe ảnh
            transformations(BlurTransformation(applicationContext, 20f),
                RoundedCornersTransformation(100f)) // làm nhòe ảnh kết hopwk bo góc
        }
    }
}