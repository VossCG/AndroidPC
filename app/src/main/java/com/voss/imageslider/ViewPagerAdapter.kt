package com.voss.imageslider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private var images: List<Int>, private var name: List<String>) :
    RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {
    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImages: ImageView = itemView.findViewById(R.id.images)
        val itemName: TextView = itemView.findViewById(R.id.name_text)

        init {
            itemImages.setOnClickListener {
                val position: Int = adapterPosition
                Toast.makeText(
                    itemView.context,
                    "You clicked the ${position + 1} image",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.imagepager, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        holder.itemImages.setImageResource(images[position])
        holder.itemName.setText(name[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }

}