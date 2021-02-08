package com.example.videoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mediaController : MediaController = MediaController(this)
        mediaController.setAnchorView(videoView)


        videoView.setMediaController(mediaController)
        videoView.setVideoURI(Uri.parse("android.resource://${getPackageName()}/${R.raw.cobaogio}}"))
        videoView.requestFocus()
        videoView.start()
    }
}