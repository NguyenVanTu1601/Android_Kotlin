package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

public class UserAdapter : RecyclerView.Adapter<UserAdapter.UserHolder> {

    private var listUser : ArrayList<User>
    private var context : Context


    constructor(list: ArrayList<User>, context : Context) : super() {
        this.listUser = list
        this.context = context
    }

    public class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textName : TextView = itemView.findViewById(R.id.item_textName)
        var textAge : TextView = itemView.findViewById(R.id.item_textAge)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(LayoutInflater.from(context).inflate(R.layout.custom_item, parent,false))
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        if (holder != null){
            holder.textName.text = listUser.get(position).name
            holder.textAge.text = listUser.get(position).age
            holder.itemView.setOnClickListener {
                Toast.makeText(context, listUser.get(position).name,Toast.LENGTH_SHORT).show()
            }
        }
    }
}