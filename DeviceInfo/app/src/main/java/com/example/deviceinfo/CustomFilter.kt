package com.example.deviceinfo

import android.widget.Filter

class CustomFilter : Filter {

    var adapter : MyAdapter
    var filterList : ArrayList<Model>

    constructor(filterLists : ArrayList<Model>,myAdapter : MyAdapter){
        this.adapter = myAdapter
        this.filterList = filterLists
    }

    // lọc
    override fun performFiltering(constraint: CharSequence?): FilterResults {
        var result : FilterResults = FilterResults()
        if (constraint != null && constraint.length > 0){

            // change to uppercase
            val constraint = constraint.toString().toUpperCase()

            var filterModel : ArrayList<Model> = ArrayList()

            for ( i in 0..filterList.size-1){
                if (filterList.get(i).name.toUpperCase().equals(constraint)){
                    filterModel.add(filterList.get(i))
                }
            }

            // tra kq
            result.count = filterModel.size
            result.values = filterModel
        }else{
            result.count = filterList.size
            result.values = filterList
        }

        return result
    }

    // nhan kq
    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        adapter.listItem = results?.values as ArrayList<Model>
        adapter.notifyDataSetChanged()
    }


}