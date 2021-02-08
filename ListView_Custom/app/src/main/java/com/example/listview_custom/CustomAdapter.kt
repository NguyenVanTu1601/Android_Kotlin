package com.example.listview_custom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class CustomAdapter(var listGirl : ArrayList<Girl>, var context : Context) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        // Gắn view vào viewHolder
        var view : View?
        var viewHolder : ViewHolder
        if (convertView == null){
            var layoutInflater : LayoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.line_girl, null) // ánh xạ phần tử của line girl vào biến view
            viewHolder = ViewHolder(view)
            view.tag = viewHolder

        }else{
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        // Gắn dữ liệu vào viewHolder
        var girl = listGirl.get(position)
        viewHolder.image.setImageResource(girl.image)
        viewHolder.name.text = girl.name
        viewHolder.age.text = girl.age.toString()

        view?.setOnClickListener {
            Toast.makeText(context,"Bạn chọn ${girl.name}",Toast.LENGTH_SHORT).show()
        }
        return view as View
    }

    override fun getItem(position: Int): Any {
        return listGirl.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listGirl.size;
    }

    class ViewHolder(row : View){
        var image : ImageView
        var name : TextView
        var age : TextView

        init {
            image = row.findViewById(R.id.line_imageView)
            name = row.findViewById(R.id.line_textName)
            age = row.findViewById(R.id.line_textAge)
        }
    }

}