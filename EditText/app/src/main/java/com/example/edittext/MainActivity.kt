package com.example.edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var listItem : ArrayList<String>? = null
    var adapter : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listItem = arrayListOf("Nguyễn Văn Tú", "Phùng Đình Tùng", "Trịnh Đình Trung", "Bố", "Mẹ")
        adapter = ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1, listItem!!)
        listView.adapter = adapter

        edtSearch.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                //Toast.makeText(this@MainActivity,"After change",Toast.LENGTH_SHORT).show()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Toast.makeText(this@MainActivity,"Before change",Toast.LENGTH_SHORT).show()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter!!.filter.filter(s)
            }

        })
    }
}