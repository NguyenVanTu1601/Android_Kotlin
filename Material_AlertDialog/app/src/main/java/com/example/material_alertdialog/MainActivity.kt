package com.example.material_alertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mAlertItems : Array<CharSequence> = arrayOf("Java", "Kotlin", "Swift", "React native")

        showDialogBtn.setOnClickListener {

            var dialog = MaterialAlertDialogBuilder(this)
            with(dialog){
                title = "View Option"
                //setMessage("This is a simple alert dialog")
                setIcon(R.drawable.ic_baseline_cloud_download_24)

                setSingleChoiceItems(mAlertItems,0,DialogInterface.OnClickListener { dialog, which ->
                    Snackbar.make(showDialogBtn, "Bạn chọn : ${mAlertItems.get(which)}", Snackbar.LENGTH_LONG).show()
                })

                setBackground(resources.getDrawable(R.drawable.alert_dialog_bg,null))
                setPositiveButton("OKAY", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this@MainActivity,"Bạn chọn OKAY!", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                    // which dùng cho chọn item trong 1 list
                })

                setNegativeButton("Dismiss", DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
            }

            dialog.show()
        }
    }
}