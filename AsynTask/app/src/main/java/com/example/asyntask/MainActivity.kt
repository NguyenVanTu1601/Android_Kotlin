package com.example.asyntask

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnXuly.setOnClickListener {
            Asyn().execute()
        }
    }

    // Tạo inner class do các view : textView, button... gắn liền với activity, thêm inner nghĩa là class Asyn là 1 phần
    // của activity nên có thể gọi tới các view này
    inner class Asyn : AsyncTask<Void, String, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            textView.text = "Bắt đầu thực hiện \n"
        }
        override fun doInBackground(vararg params: Void?): String {

            for (cv in 1..5){
                publishProgress("Thực hiện việc ${cv} \n")
                Thread.sleep(1000)
            }
            return "Kết thúc công việc"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            textView.append(result)
        }

        // đón nhận kết quả của publishProgress
        override fun onProgressUpdate(vararg values: String?) {
            super.onProgressUpdate(*values)
            textView.append(values[0]) // do trên chỉ truyền vào 1 phần tử còn *values là 1 mảng kq
        }
    }
}