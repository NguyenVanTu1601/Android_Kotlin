package com.example.dialog_alert

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val neutralButtonClick = { dialog : DialogInterface,
                               which : Int ->
        Toast.makeText(this,"Bạn chọn cancle...",Toast.LENGTH_SHORT).show()
        dialog.dismiss()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowDialogBasic.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                showDialogBasic()
            }

        })

        btnShowDialogCustom.setOnClickListener {
            showDialogCustom()
        }

        btnShowDialogListItem.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                showDialogListItem()
            }

        })

        btnShowDialogChoice.setOnClickListener {
            withMultiChoiceList(it)
        }
    }

    fun showDialogBasic(){
        var alerDialog  = AlertDialog.Builder(this)

        with(alerDialog){
            setTitle("Android Alert!")
            setMessage("Bạn chọn cái nào trong đây ???")
            setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this@MainActivity,"Bạn chọn yes!",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })

            setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this@MainActivity,"Bạn chọn no!",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })

            setNeutralButton("Cancle", neutralButtonClick)

            // show()
        }

        alerDialog.show()
    }

    fun showDialogCustom(){
        var builder = AlertDialog.Builder(this)
        with(builder){
            setTitle("Infomation")
            var dialogLayout = layoutInflater.inflate(R.layout.layout_dialog,null)
            setView(dialogLayout)
            setCancelable(false)
            val edtName : EditText = dialogLayout.findViewById(R.id.edtName)
            val edtAddess : EditText = dialogLayout.findViewById(R.id.edtAddess)
            val edtAge : EditText = dialogLayout.findViewById(R.id.edtAge)
            val btnSubmit : Button = dialogLayout.findViewById(R.id.btnSubmit)

            // show dialog
            var mAler = builder.show()

            btnSubmit.setOnClickListener {
                Toast.makeText(this@MainActivity,
                    "Xin chào ${edtName.text}, bạn sống ở ${edtAddess.text}, bạn ${edtAge.text} tuổi",
                    Toast.LENGTH_SHORT).show()
                 mAler.dismiss()
            }
        }


    }

    fun showDialogListItem(){
        var builder = AlertDialog.Builder(this)
        with(builder){

            var items = arrayOf("Kotlin,", "Java", "JS", "C#")
            setTitle("List Language")
            setItems(items){
                 dialog : DialogInterface, which : Int ->
                Toast.makeText(this@MainActivity,items[which] + " clicked!", Toast.LENGTH_SHORT).show()
            }

            setPositiveButton("Close", DialogInterface.OnClickListener{
                dialog: DialogInterface?, which: Int ->
                dialog?.dismiss()
            })
        }

        builder.show()
    }

    fun withMultiChoiceList(view: View) {

        val items = arrayOf("Microsoft", "Apple", "Amazon", "Google")
        val selectedList = ArrayList<Int>()
        val builder = AlertDialog.Builder(this)

        builder.setTitle("This is list choice dialog box")
        builder.setMultiChoiceItems(items, null
        ) { dialog, which, isChecked ->
            if (isChecked) {
                selectedList.add(which)
            } else if (selectedList.contains(which)) {
                selectedList.remove(Integer.valueOf(which))
            }
        }

        builder.setPositiveButton("DONE") { dialogInterface, i ->
            val selectedStrings = ArrayList<String>()

            for (j in selectedList.indices) {
                selectedStrings.add(items[selectedList[j]])
            }

            Toast.makeText(applicationContext, "Items selected are: " + Arrays.toString(selectedStrings.toTypedArray()), Toast.LENGTH_SHORT).show()
        }

        builder.show()

    }
}