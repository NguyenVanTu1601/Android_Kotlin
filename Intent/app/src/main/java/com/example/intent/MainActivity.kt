package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonMain.setOnClickListener {
            var intent : Intent = Intent(this, IntentActivity::class.java)
            // intent.putExtra("data", "Nguyễn Văn Tú") //truyền chuỗi
            // intent.putExtra("data", 2020) // truyền số

            // truyền array
            //var arr : IntArray = intArrayOf(1,2,3)
            //intent.putExtra("data", arr)

            // truyền đối tượng
            //var sv : SinhVien = SinhVien("Nguyễn Văn Tú",21,"Thái Bình")
            //intent.putExtra("data",sv)

            // truyền nhận thông qua bundle
            var bundle : Bundle = Bundle()
            bundle.putString("name", "Tú Nguyễn")
            intent.putExtra("bundle", bundle)

            startActivity(intent)
        }
    }
}