package com.example.snackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        snackbar_btn.setOnClickListener {
            var snack : Snackbar = Snackbar.make(mSnackBarLayout,
                "You just clicked the snackbar button!",Snackbar.LENGTH_LONG) // thay mSnackBarLayout = it cung được
            snack.setDuration(3000) // thời gian hiển thị
            //snack.anchorView = floatAcButton // hien thi tren floating action button
            snack.animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE
            snack.setAction("OKAY", View.OnClickListener {
                // Do something
            })
            snack.show()
        }
    }
}