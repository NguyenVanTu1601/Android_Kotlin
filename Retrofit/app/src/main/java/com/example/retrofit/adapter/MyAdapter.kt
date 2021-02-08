package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.model.Post
import kotlinx.android.synthetic.main.row_layout.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var myList = emptyList<Post>()


    inner class MyViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var post = myList.get(position)
        holder.itemView.userId_txt.text = post.myUserId.toString()
        holder.itemView.Id_txt.text = post.id.toString()
        holder.itemView.title_txt.text = post.title.toString()
        holder.itemView.body_txt.text = post.body.toString()
    }

    fun setData(newList : List<Post>){
        myList = newList
        notifyDataSetChanged()
    }
}