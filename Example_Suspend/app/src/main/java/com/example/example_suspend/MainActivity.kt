package com.example.example_suspend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

/**
 * Trong ví dụ này định tạo 1 luồng suspend CountDown nhưng dùng runBlocking xong thì nó lại tự tạo luồng riêng luôn :))
 * -> Nói chung vẫn chưa biết dùng từ khóa suspend nhưng đã hiểu Coroutine nó như kiểu cái asyntask vậy
 * -> Nó giúp tạo luồng chạy độc lập với main UI
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var number = 0

        // luồng đếm ngược
        runBlocking {
            countDownTimmer()
        }

//        GlobalScope.launch {
//            countDownTimmer()
//        }

        // bấm nút add thì đếm tăng số
        btn_add.setOnClickListener {
            number++
            txt_add.text = number.toString()
        }
    }

    fun countDownTimmer(){

        var timer =object : CountDownTimer(20000,1000){
            override fun onTick(millisUntilFinished: Long) {
                var time = millisUntilFinished / 1000;
                txt_countdown.text = time.toString()
            }

            override fun onFinish() {
                txt_countdown.text = "Finished..."
            }

        }.start()
    }

    // viết để học thôi
    suspend fun delayTimer(){
        delay(1000)
    }

    suspend fun test(){
        /**
         * Một số loại Dispatchers :
         * + IO : Optimized for network and disk operations
         * + Main : Optimized for UI code or non-blocking code that executes fast
         * + Default : Optimized for CPU-intensive task and some bigger computations
         * +
         */
        withContext(Dispatchers.IO){
            // do something
        }
    }

}