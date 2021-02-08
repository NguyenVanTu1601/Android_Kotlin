package com.example.learnkotlinex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener{

    var no1 : Int = 0
    var no2 : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnADD.setOnClickListener(this)
        btnSUB.setOnClickListener(this)
        btnMUL.setOnClickListener(this)
        btnDIV.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.btnADD -> {
                var no1String : String = edtNo1.text.toString()
                var no2String : String = edtNo2.text.toString()
                if (no1String.equals("") || no2String.equals("")){
                    Toast.makeText(this@MainActivity, "Điền đủ 2 số nào bé ơi...", Toast.LENGTH_SHORT).show();
                }else{
                    no1 = edtNo1.text.toString().toInt()
                    no2 = edtNo2.text.toString().toInt()
                    txtKq.text = "Tổng 2 số = ${no1 + no2}"
                }


            }
            R.id.btnMUL -> {
                var no1String : String = edtNo1.text.toString()
                var no2String : String = edtNo2.text.toString()
                if (no1String.equals("") || no2String.equals("")){
                    Toast.makeText(this@MainActivity, "Điền đủ 2 số nào bé ơi...", Toast.LENGTH_SHORT).show();
                }else{
                    no1 = edtNo1.text.toString().toInt()
                    no2 = edtNo2.text.toString().toInt()
                    txtKq.text = "Tích 2 số = ${no1 * no2}"
                }

            }
            R.id.btnSUB -> {
                var no1String : String = edtNo1.text.toString()
                var no2String : String = edtNo2.text.toString()
                if (no1String.equals("") || no2String.equals("")){
                    Toast.makeText(this@MainActivity, "Điền đủ 2 số nào bé ơi...", Toast.LENGTH_SHORT).show();
                }else{
                    no1 = edtNo1.text.toString().toInt()
                    no2 = edtNo2.text.toString().toInt()
                    txtKq.text = "Hiệu 2 số = ${no1 - no2}"
                }

            }
            R.id.btnDIV -> {
                var no1String : String = edtNo1.text.toString()
                var no2String : String = edtNo2.text.toString()
                if (no1String.equals("") || no2String.equals("")){
                    Toast.makeText(this@MainActivity, "Điền đủ 2 số nào bé ơi...", Toast.LENGTH_SHORT).show();
                }else{
                    no1 = edtNo1.text.toString().toInt()
                    no2 = edtNo2.text.toString().toInt()
                    txtKq.text = "Thương 2 số = ${no1 / no2}"
                }

            }
            else -> {
                // do nothing
            }
        }
    }
}