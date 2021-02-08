package com.example.menu_popupwindow

import android.app.ActionBar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.menu_popupwindow.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mPopupMenu : PopupWindow
    private var isCheck : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        popup_menu.setOnClickListener {

            if (isCheck){
                isCheck = false
                var inflater : LayoutInflater = applicationContext.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater

                var customView : View = inflater.inflate(R.layout.menu_layout,null)
                mPopupMenu = PopupWindow(
                    customView,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                if(Build.VERSION.SDK_INT>=21){
                    mPopupMenu.elevation = 0.5f
                }

                mPopupMenu.showAtLocation(main_layout, Gravity.RIGHT , 50 , 0)
            }

        }

        close_menu.setOnClickListener {
            if (isCheck == false){
                mPopupMenu.dismiss()
                isCheck = true
            }

        }

        /*
        public void showAtLocation (View parent, int gravity, int x, int y)
        Display the content view in a popup window at the specified location. If the
        popup window cannot fit on screen, it will be clipped.
        Learn WindowManager.LayoutParams for more information on how gravity and the x
                and y parameters are related. Specifying a gravity of NO_GRAVITY is similar
        to specifying Gravity.LEFT | Gravity.TOP.

        Parameters
        parent : a parent view to get the getWindowToken() token from
        gravity : the gravity which controls the placement of the popup window
        x : the popup's x location offset
        y : the popup's y location offset
        */
    }
}