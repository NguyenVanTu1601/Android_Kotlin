package com.example.customfilter_adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView

class StudentAdapter(var listItem : ArrayList<Student>, var context : Context) : BaseAdapter(), Filterable {

    var filterList : ArrayList<Student> = listItem
    var customFilter : CustomFilter = CustomFilter(this, filterList)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : View?
        var viewHolder : ViewHolder


        if (convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_student,null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        var st : Student = listItem.get(position)
        viewHolder.textName?.text = st.name
        viewHolder.textAddress?.text = st.address
        viewHolder.textAge?.text = st.age.toString()

        view?.setOnClickListener {

        }

        return view as View
    }

    override fun getItem(position: Int): Any {
        return listItem.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listItem.size
    }

    class ViewHolder(row : View){
        var textName : TextView? = null
        var textAddress : TextView? = null
        var textAge : TextView? = null

        init {
            textName = row.findViewById(R.id.item_name)
            textAddress = row.findViewById(R.id.item_address)
            textAge = row.findViewById(R.id.item_age)
        }
    }

    override fun getFilter(): Filter {

        if (filterList == null){
            customFilter = CustomFilter(this, filterList)
        }
        return customFilter
    }
}