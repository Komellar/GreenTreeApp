package com.tutorial.greentreeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tutorial.greentreeapp.R
import com.tutorial.greentreeapp.model.Designer

class DesignerAdapter (
    private val context: Context,
    private val dataset: List<Designer>
    ) : RecyclerView.Adapter<DesignerAdapter.ItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.ivPhoto)
        val nameTV: TextView = view.findViewById(R.id.tvName)
        val descriptionTV: TextView = view.findViewById(R.id.tvDescription)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_designer, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.nameTV.text = item.nameResourceId
        holder.descriptionTV.text = context.resources.getString(item.descResourceId)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}