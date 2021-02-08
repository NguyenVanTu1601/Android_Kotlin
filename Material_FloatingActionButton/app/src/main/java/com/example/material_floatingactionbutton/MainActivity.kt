package com.example.material_floatingactionbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fabOpen : Animation = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        var fabClose : Animation = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        var isOpen : Boolean = false
        main_add_fab.setOnClickListener {
            if (isOpen){
                add_contact_fab.animation = fabClose
                add_user_fab.animation = fabClose

                add_contact_text.visibility = View.INVISIBLE
                add_user_text.visibility = View.INVISIBLE

                isOpen = false
            }else{
                add_contact_fab.animation = fabOpen
                add_user_fab.animation = fabOpen

                add_contact_text.visibility = View.VISIBLE
                add_user_text.visibility = View.VISIBLE

                isOpen = true
            }
        }
    }
}