package com.example.volumesetup

import android.content.Context
import android.media.AudioManager
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    /** The audio stream for phone calls  */
    val STREAM_VOICE_CALL: Int = AudioManager.STREAM_VOICE_CALL

    /** The audio stream for system sounds  */
    val STREAM_SYSTEM: Int = android.media.AudioManager.STREAM_SYSTEM

    /** The audio stream for the phone ring  */
    val STREAM_RING: Int = android.media.AudioManager.STREAM_RING

    /** The audio stream for music playback  */
    val STREAM_MUSIC: Int = android.media.AudioManager.STREAM_MUSIC

    /** The audio stream for alarms  */
    val STREAM_ALARM: Int = android.media.AudioManager.STREAM_ALARM

    /** The audio stream for notifications  */
    val STREAM_NOTIFICATION: Int = android.media.AudioManager.STREAM_NOTIFICATION


    /** The audio stream for DTMF Tones  */
    val STREAM_DTMF: Int = android.media.AudioManager.STREAM_DTMF



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var audioManager : AudioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        seekbarVolume.max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)

        seekbarVolume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                editText.text = progress.toString()
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //
            }

        })
    }
}