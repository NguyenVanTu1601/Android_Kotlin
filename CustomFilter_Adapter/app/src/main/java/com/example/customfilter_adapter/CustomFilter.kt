package com.example.customfilter_adapter

import android.widget.Filter

class CustomFilter : Filter {

    var adapter : StudentAdapter
    var filterList : ArrayList<Student>

    constructor(adapter: StudentAdapter, listStudent : ArrayList<Student>){
        this.adapter = adapter
        this.filterList = listStudent
    }


    // xử lý
    override fun performFiltering(constraint: CharSequence?): FilterResults {
        var result : FilterResults = FilterResults()
        if (constraint != null && constraint.length > 0){
            var filterModel : ArrayList<Student> = ArrayList()
            var cs = constraint.toString().toUpperCase()
            for (i in 0..filterList.size-1){
                if (filterList.get(i).name.toUpperCase().indexOf(cs) >= 0){
                    filterModel.add(filterList.get(i))
                }
            }

            result.count = filterModel.size
            result.values = filterModel
        }else{
            result.count = filterList.size
            result.values = filterList
        }
        return result
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        adapter.listItem = results?.values as ArrayList<Student>
        adapter.notifyDataSetChanged()
    }
}