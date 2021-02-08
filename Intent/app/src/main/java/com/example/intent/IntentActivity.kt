package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent.*

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        // var name : String = intent.getStringExtra("data")
        // val year : Int = intent.getIntExtra("data",1999)

        // Nhận array
        // var arr : IntArray = intent.getIntArrayExtra("data")

        // Nhận object
        //var sv : SinhVien = intent.getSerializableExtra("data") as SinhVien

        // Nhận Bundle
        var bundle : Bundle = intent.getBundleExtra("bundle")
        if (bundle != null){
            txtIntent.text = bundle.getString("name")
        }


        buttonIntent.setOnClickListener {
            var intent : Intent = Intent(this@IntentActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}