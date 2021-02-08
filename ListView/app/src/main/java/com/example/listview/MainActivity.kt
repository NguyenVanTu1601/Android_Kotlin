package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listSubject : List<String> = listOf("Java web", "Java Android", "Kotlin Android", "IOS")
        listView.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listSubject)
        listView.setOnItemClickListener(object : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity, "Bạn chọn ${listSubject.get(position)}",
                    Toast.LENGTH_SHORT).show()
            }

        })
    }
}