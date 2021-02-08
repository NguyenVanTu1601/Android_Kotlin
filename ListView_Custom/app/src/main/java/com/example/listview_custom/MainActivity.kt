package com.example.listview_custom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listGirl : ArrayList<Girl> = ArrayList()
        listGirl.add(Girl(R.drawable.image, "Girl 1", 18))
        listGirl.add(Girl(R.drawable.image1, "Girl 2", 20))
        listGirl.add(Girl(R.drawable.image2, "Girl 3", 16))
        listGirl.add(Girl(R.drawable.images3, "Girl 4", 22))
        listGirl.add(Girl(R.drawable.images4, "Girl 5", 19))
        listGirl.add(Girl(R.drawable.image5, "Girl 6", 23))
        listGirl.add(Girl(R.drawable.image6, "Girl 7", 21))
        listGirl.add(Girl(R.drawable.image7, "Girl 8", 24))
        listGirl.add(Girl(R.drawable.image10, "Girl 9", 20))


        var adapter : CustomAdapter = CustomAdapter(listGirl, this@MainActivity)
        listView.adapter = adapter
        adapter.notifyDataSetChanged()

    }
}