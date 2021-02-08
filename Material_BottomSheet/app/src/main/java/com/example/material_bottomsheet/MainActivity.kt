package com.example.material_bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onClickItem()
        var bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet_layout)


        bottom_app_bar.setNavigationOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        textHeader.setOnClickListener {
            if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED){
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }else{
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }


        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                //
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                //
            }

        })
    }

    fun onClickItem(){
        share.setOnClickListener {
            Toast.makeText(this@MainActivity,"Bạn chọn share!",Toast.LENGTH_SHORT).show()
        }
        save.setOnClickListener {
            Toast.makeText(this@MainActivity,"Bạn chọn Save!",Toast.LENGTH_SHORT).show()
        }
        upload.setOnClickListener {
            Toast.makeText(this@MainActivity,"Bạn chọn Upload!",Toast.LENGTH_SHORT).show()
        }
    }
}