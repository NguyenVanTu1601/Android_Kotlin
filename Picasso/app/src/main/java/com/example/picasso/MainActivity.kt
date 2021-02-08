package com.example.picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var url : String = "https://kenh14cdn.com/thumb_w/660/2020/6/5/" +
                "006mrmprly1gdx6exf3lyj30u01rcasm-15913263980501789002707-crop-15913264120321997228444.jpg"
        Picasso.get().load(url)
                .placeholder(R.drawable.ic_launcher_background).into(imageView)
    }
}