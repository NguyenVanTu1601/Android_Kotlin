package com.example.bottomappbar_material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(bottom_appbar)

        // navigaIcon là cái icon menu nên đây là bắt sự kiện khi click hình menu thì fab sẽ chuyển về giữa
        bottom_appbar.setNavigationOnClickListener {
            bottom_appbar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.bottom_app_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.bottom_add_user -> {
                Toast.makeText(this@MainActivity, "Bạn chọn thêm user!",Toast.LENGTH_SHORT).show()
            }

            R.id.bottom_add_contact -> {
                Toast.makeText(this@MainActivity, "Bạn chọn thêm contact!",Toast.LENGTH_SHORT).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }


}


