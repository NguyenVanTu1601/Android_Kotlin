package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listUser : ArrayList<User> = ArrayList()
        listUser.add(User("Nguyễn Văn Tú", "21"))
        listUser.add(User("Phùng Đình Tùng", "21"))
        listUser.add(User("Trịnh Đình Trung", "21"))
        listUser.add(User("Nguyễn Văn Tài", "18"))
        with(recyclerView){

            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = UserAdapter(listUser, this@MainActivity)

        }
    }
}