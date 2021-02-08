package com.example.customfilter_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Custom lại bộ lọc filter của adapter
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listStudent : ArrayList<Student> = ArrayList()
        listStudent.add(Student("Nguyễn Văn Tú","Hà Nội", 21))
        listStudent.add(Student("Phùng Đình Tùng", "Lào Cai", 22))
        listStudent.add(Student("Trịnh Đình Trung", "Thanh Hóa", 21))

        var adapter : StudentAdapter = StudentAdapter(listStudent, this)
        listView.adapter = adapter

        edtSearch.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                //
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.customFilter.filter(s.toString())
            }

        })
    }
}