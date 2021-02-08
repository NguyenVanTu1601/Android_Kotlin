package com.example.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.core.view.MenuItemCompat
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var listItem : ArrayList<String>? = null
    var adapterList : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        var textV : TextView = toolbar.findViewById(R.id.myEditText)
        var imgSearch : ImageView = toolbar.findViewById(R.id.imgSearch)

        listItem  = arrayListOf("Swift", "Kotlin", "Java", "C#", "C++", "GoLang")
        adapterList = ArrayAdapter(this,android.R.layout.simple_list_item_1, listItem!!)
        listView.adapter = adapterList

        imgSearch.setOnClickListener {
            textV.visibility = View.VISIBLE
            //Toast.makeText(this@MainActivity, textV.text, Toast.LENGTH_SHORT).show()
        }
    }

}