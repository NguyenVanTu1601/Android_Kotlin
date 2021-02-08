package com.example.mediaplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var play : Boolean = true
        var position : Int = 0

        var listMp3 : ArrayList<Music> = ArrayList()
        listMp3.add(Music("Có bao giờ", R.raw.co_bao_gio))
        listMp3.add(Music("Hơn cả yêu", R.raw.hon_ca_yeu))
        listMp3.add(Music("Sáng nay mưa", R.raw.sang_nay_mua))

        var mp : MediaPlayer = MediaPlayer.create(this, listMp3.get(position).id)
        mp3_name.text = listMp3.get(position).name
        mp.start()

        mp3_play.setOnClickListener {
            if (mp.isPlaying){
                play = false
                mp.pause()
                mp3_play.setImageResource(R.drawable.ic_play)
            }else{
                play = true
                mp.start()
                mp3_play.setImageResource(R.drawable.ic_pause)

            }
        }

        mp3_next.setOnClickListener {
            position++
            if (position > listMp3.size - 1){
                position = 0
            }
            if (mp.isPlaying){
                mp.stop()
                mp.release()
            }
            if (play == false){
                play = true
                mp3_play.setImageResource(R.drawable.ic_pause)
            }
            mp = MediaPlayer.create(this, listMp3.get(position).id)
            mp3_name.text = listMp3.get(position).name
            mp.start()
        }

        mp3_previous.setOnClickListener {
            position--
            if (position < 0){
                position = listMp3.size - 1
            }
            if (mp.isPlaying){
                mp.stop()
                mp.release()
            }
            if (play == false){
                play = true
                mp3_play.setImageResource(R.drawable.ic_pause)
            }
            mp = MediaPlayer.create(this, listMp3.get(position).id)
            mp3_name.text = listMp3.get(position).name
            mp.start()
        }

    }



}