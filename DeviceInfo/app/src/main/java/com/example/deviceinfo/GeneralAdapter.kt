package com.example.deviceinfo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class GeneralAdapter : BaseAdapter {

    var context : Context
    var titles : ArrayList<String>
    var description : ArrayList<String>

    constructor(context: Context, titles : ArrayList<String>, des : ArrayList<String>){
        this.context = context
        this.titles = titles
        this.description = des
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : View?
        var viewHolder : ViewHolder
        if (convertView == null){
            var layoutInflater : LayoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.tworow, null) // ánh xạ phần tử của line girl vào biến view
            viewHolder = ViewHolder(view)
            view.tag = viewHolder

        }else{
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        // Gắn dữ liệu vào viewHolder
        viewHolder.title.text = titles[position]
        viewHolder.des.text = description[position]

        view?.setOnClickListener {
            Toast.makeText(context,"Bạn chọn ${titles[position]}", Toast.LENGTH_SHORT).show()
        }
        return view as View
    }

    override fun getItem(position: Int): Any {
        return titles[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return titles.size
    }

    class ViewHolder(row : View){
        var title : TextView
        var des : TextView

        init {
            title = row.findViewById(R.id.titleTv)
            des = row.findViewById(R.id.descTv)
        }
    }
}