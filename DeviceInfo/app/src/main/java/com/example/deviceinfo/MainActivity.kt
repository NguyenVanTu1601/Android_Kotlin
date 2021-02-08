package com.example.deviceinfo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var myAdapter : MyAdapter
    init {
        myAdapter = MyAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        toolbar.setTitle("Wellcome")

        var listItem : ArrayList<Model> = getModel()
        var myAdapter = MyAdapter(this@MainActivity, listItem)

        with(recyclerView){
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            itemAnimator = DefaultItemAnimator()
            adapter = myAdapter
        }

//        // device manufacture name
        var mManufacture : String = Build.MANUFACTURER
        deviceName.text = mManufacture

        //device model
        var model : String = Build.MODEL
        deviceModel.text = model

        //device android version
        var version = Build.VERSION.RELEASE
        deviceVersion.text = version


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            imageDevice.setImageResource(R.drawable.android41)
        }else{
            imageDevice.setImageResource(R.drawable.android44)
        }
    }

    fun getModel() : ArrayList<Model>{
        var models : ArrayList<Model> = ArrayList()

        var p = Model("General", R.drawable.general)
        models.add(p)

        p = Model("Device Id", R.drawable.devid)
        models.add(p)

        p = Model("Display", R.drawable.display)
        models.add(p)

        p = Model("Battery", R.drawable.battery)
        models.add(p)

        p = Model("User Apps", R.drawable.userapps)
        models.add(p)

        p = Model("System Apps", R.drawable.systemapps)
        models.add(p)

        p = Model("Memory", R.drawable.memory)
        models.add(p)

        p = Model("CPU", R.drawable.cpu)
        models.add(p)

        p = Model("Sensors ", R.drawable.sensor)
        models.add(p)

        p = Model("SIM", R.drawable.sim)
        models.add(p)


        return models
    }

     override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)
        var item : MenuItem? = menu?.findItem(R.id.actionSearch)
        var searchView : SearchView = MenuItemCompat.getActionView(item) as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                myAdapter.customFilter.filter(query)
                return false

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                myAdapter.customFilter.filter(newText)
                return false
            }

        })
        return true

    }

}