package com.example.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var countDown : CountDownTimer? = null
    var mHandler : Handler? = null
    var mThread : Thread? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initHandler()

        var time : Int = 20
        showCountDown.setOnClickListener {
            startCountDown(time)

        }

        showHandler.setOnClickListener {
            startHandelr(time)
        }


    }

    private fun startCountDown(time  :Int) {
        progess_Bar.visibility = View.VISIBLE
        countDown = object : CountDownTimer((time * 1000).toLong(), 10){
            override fun onTick(millisUntilFinished: Long) {
                textCountDown.text = (millisUntilFinished/1000).toString()
                if ((millisUntilFinished/1000).toInt() == 0){
                    progess_Bar.visibility = View.INVISIBLE
                }
            }

            override fun onFinish() {
                Toast.makeText(this@MainActivity, "Finish!",Toast.LENGTH_SHORT).show()
            }

        }.start()
    }

    private fun startHandelr(time : Int){
        var t = time
        mThread = Thread(Runnable {
            while (t > 0){
                if (t > 0){
                    t = t - 1
                    var mess : Message = Message()
                    mess.what = 1000
                    mess.arg1 = t
                    mHandler?.sendMessage(mess)
                    Thread.sleep(1000)
                }else{
                    return@Runnable
                }
            }
        })

        mThread?.start()
    }

    private fun initHandler(){
        mHandler = object : Handler(){
            override fun handleMessage(msg: Message) {
                if (msg.what == 1000){
                    var time : Int = msg.arg1
                    if (time >= 0){
                        textHandler.text = time.toString()
                    }
                    if (time == 0){
                        Toast.makeText(this@MainActivity,"Finish Handler...",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

