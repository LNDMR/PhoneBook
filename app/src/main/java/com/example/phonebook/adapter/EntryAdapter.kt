package com.example.phonebook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebook.R
import com.example.phonebook.data.modul.Entry
import com.example.phonebook.ui.HomeFragmentDirections
import com.google.android.material.card.MaterialCardView

class EntryAdapter(private val dataset: List<Entry>, private val deleteEntry: (Entry) -> Unit)
    : RecyclerView.Adapter<EntryAdapter.ViewHolder>() {

    // define those parts of the layout that shall be renewed before displaying
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val entryName = view.findViewById<TextView>(R.id.entry_name_text)
        val entryNumber = view.findViewById<TextView>(R.id.entry_number_text)
        val entryImageResource = view.findViewById<ImageView>(R.id.entry_image)
        val deleteImageButton = view.findViewById<ImageView>(R.id.entry_delete_image)
        val entryCard = view.findViewById<MaterialCardView>(R.id.entry_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.entry_item, parent, false)
        return ViewHolder(adapterLayout)
    }

    // recycling process starts
    // the attributes of the ViewHolder are renewed
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = dataset[position]

        holder.entryName.text = entry.name
        holder.entryNumber.text = entry.mobileNumber
        holder.entryImageResource.setImageResource(entry.imageResource)

        holder.deleteImageButton.setOnClickListener {
            deleteEntry(entry)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, dataset.lastIndex)
        }

        holder.entryCard.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(entry))
        }
    }

    // layoutManager needs to know amount of items
    override fun getItemCount(): Int {
        return dataset.size
    }


}