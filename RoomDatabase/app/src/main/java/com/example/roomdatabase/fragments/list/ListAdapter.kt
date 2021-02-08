package com.example.roomdatabase.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.model.User
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currenItem = userList.get(position)
        holder.itemView.id_txt.text = currenItem.id.toString()
        holder.itemView.firstname_txt.text = currenItem.firstName
        holder.itemView.lastname_txt.text = currenItem.lastName
        holder.itemView.age_txt.text = currenItem.age.toString()
        holder.itemView.rowLayoutCustom.setOnClickListener {
            var action = ListFragmentDirections.actionListFragmentToUpdateFragment(currenItem)
            holder.itemView.findNavController().navigate(action)

        }

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(users : List<User>){
        this.userList = users
        notifyDataSetChanged()
    }
}