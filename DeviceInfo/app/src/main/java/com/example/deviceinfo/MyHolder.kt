package com.example.deviceinfo

import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var img : ImageView
    var nameTxt : TextView

    init {
        img = itemView.findViewById(R.id.modelImage)
        nameTxt = itemView.findViewById(R.id.modelTxt)
    }

}