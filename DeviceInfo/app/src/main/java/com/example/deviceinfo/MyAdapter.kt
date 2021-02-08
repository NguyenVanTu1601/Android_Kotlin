package com.example.deviceinfo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter() : RecyclerView.Adapter<MyHolder>(), Filterable{

    lateinit var context : Context
    lateinit var listItem : ArrayList<Model>
    lateinit var filterList : ArrayList<Model>
    lateinit var customFilter : CustomFilter

    constructor(context: Context, list : ArrayList<Model>) : this() {
        this.context = context
        this.listItem = list
        this.filterList = listItem
        customFilter = CustomFilter(filterList,this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.model,parent,false))
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        if (holder != null){
            holder.nameTxt.text = listItem.get(position).name
            holder.img.setImageResource(listItem.get(position).img)
            holder.itemView.setOnClickListener {
                if (listItem.get(position).name.equals("General")){
                    Toast.makeText(context, "General",Toast.LENGTH_SHORT).show()
                    var intent : Intent = Intent(context, GeneralActivity::class.java)
                    context.startActivity(intent)
                }
                else if(listItem.get(position).name.equals("Device Id")){
                    Toast.makeText(context, "Device Id",Toast.LENGTH_SHORT).show()
                }
                else if (listItem.get(position).name.equals("Display")){
                    Toast.makeText(context, "Display",Toast.LENGTH_SHORT).show()
                }
                else if (listItem.get(position).name.equals("Battery")){
                    Toast.makeText(context, "Battery",Toast.LENGTH_SHORT).show()
                }
                else if (listItem.get(position).name.equals("User Apps")){
                    Toast.makeText(context, "User Apps",Toast.LENGTH_SHORT).show()
                }
                else if (listItem.get(position).name.equals("System Apps")){
                    Toast.makeText(context, "System Apps",Toast.LENGTH_SHORT).show()
                }
                else if (listItem.get(position).name.equals("Memory")){
                    Toast.makeText(context, "Memory",Toast.LENGTH_SHORT).show()
                }
                else if (listItem.get(position).name.equals("CPU")){
                    Toast.makeText(context, "CPU",Toast.LENGTH_SHORT).show()
                }
                else if (listItem.get(position).name.equals("Sensors")){
                    Toast.makeText(context, "Sensors",Toast.LENGTH_SHORT).show()
                }
                else if (listItem.get(position).name.equals("SIM")){
                    Toast.makeText(context, "SIM",Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    override fun getFilter(): Filter {
        if (filterList == null){
            customFilter = CustomFilter(filterList,this)
        }
        return customFilter
    }
}