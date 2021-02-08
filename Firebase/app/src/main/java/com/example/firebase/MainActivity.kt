package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    var myRef : DatabaseReference

    init {
        myRef = FirebaseDatabase.getInstance().reference
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        btnSave.setOnClickListener {saveData()}

        onDataChange()
    }

    // readData
    fun onDataChange(){
        var postListener = object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                var data : ArrayList<User> = ArrayList()
                if (snapshot != null){
                    for (dataSnapShot in snapshot.children){
                        Toast.makeText(this@MainActivity, dataSnapShot.key,Toast.LENGTH_SHORT).show()
                        var user : User? = dataSnapShot.getValue(User::class.java)

                        //user?.let { it1 -> data.add(it1) }
                        data.add(user!!)
                    }
                }

                var user : User = data.get(0)
                viewData(user)
            }

        }
        myRef.child("Information").addValueEventListener(postListener)
    }

    // Save Data
    fun saveData(){
        var name : String = textName.text.toString()
        var address : String = textAddress.text.toString()
        var age : String = textAge.text.toString()

        var map : HashMap<String, String> = HashMap()
        map.put("name",name)
        map.put("address", address)
        map.put("age", age)

        myRef.child("Information").push().setValue(map)
            .addOnCompleteListener {task->
                if (task.isSuccessful){
                    Toast.makeText(this,"Thêm thành công...", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Thêm thất bại...", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun viewData(user : User) {
        textName.setText(user.getName())
        textAddress.setText(user.getAddress())
        textAge.setText(user.getAge())
    }
}