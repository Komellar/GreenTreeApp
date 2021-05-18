package com.tutorial.greentreeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.tutorial.greentreeapp.R
import com.tutorial.greentreeapp.model.Plant

class PlantAdapter(var context: Context, var arrayList: ArrayList<Plant>) : RecyclerView.Adapter<PlantAdapter.ItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_plant, parent, false )
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var plant:Plant = arrayList.get(position)

        holder.plantImage.setImageResource(plant.image!!)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var plantImage = itemView.findViewById<ImageView>(R.id.plantImage)
    }
}