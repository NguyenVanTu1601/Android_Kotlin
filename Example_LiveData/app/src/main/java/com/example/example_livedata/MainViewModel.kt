package com.example.example_livedata

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private lateinit var timer : CountDownTimer
    private var _seconds = MutableLiveData<Int>()
    public var finished = MutableLiveData<Boolean>()
    var timeValue = MutableLiveData<Long>()

    fun seconds() : LiveData<Int>{
        return _seconds
    }
    fun startTimer(){
        timer = object : CountDownTimer(timeValue.value!!.toLong(),1000){
            override fun onTick(millisUntilFinished: Long) {
                var timeLeft = millisUntilFinished/1000
                _seconds.value = timeLeft.toInt()
            }

            override fun onFinish() {
                finished.value = true
            }

        }.start()
    }

    fun stopTimer(){
        timer.cancel()
    }
}