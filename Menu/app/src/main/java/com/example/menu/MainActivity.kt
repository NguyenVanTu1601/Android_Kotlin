package com.example.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Đăng kí cho contextMenu
        var listItem : ArrayList<String> = arrayListOf("Nguyễn Văn Tú", "Phùng Đình Tùng","Trịnh Đình Trung","Bố", "Mẹ")
        var adapter  = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem)
        listView.adapter = adapter
        registerForContextMenu(listView) // đăng kí contextMenu cho đối tượng bất kì, có thể là button...

        // Đăng kí cho popup menu
        popup_menu.setOnClickListener {
            var popupMenu = PopupMenu(this, popup_menu)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener{
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    Toast.makeText(this@MainActivity,"Bạn chọn ${item?.title}",Toast.LENGTH_SHORT).show()
                    return true
                }
            })

            popupMenu.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return true
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu,menu)
        menu?.setHeaderTitle("Select Action")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        when(id){
            R.id.item_search-> {
                Toast.makeText(this,"Bạn chọn search...",Toast.LENGTH_SHORT).show()
            }
            R.id.item_setting-> {
                Toast.makeText(this,"Bạn chọn setting...",Toast.LENGTH_SHORT).show()
            }
            R.id.item_logout-> {
                Toast.makeText(this,"Bạn chọn logout...",Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var info : AdapterView.AdapterContextMenuInfo  = item.menuInfo as AdapterView.AdapterContextMenuInfo // xử lý xem chọn chỗ nào trên listView
        var pos = info.position // vị trí view được chọn trong listView

        var id = item.itemId
        when(id){
            R.id.call ->{
                Toast.makeText(this,"Bạn chọn call tới ${(info.targetView as TextView).text} ở vị trí ${pos}",Toast.LENGTH_SHORT).show()
            }
            R.id.sms ->{
                Toast.makeText(this,"Bạn muốn gửi sms tới ${(info.targetView as TextView).text}",Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }


}