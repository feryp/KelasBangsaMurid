package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.Keahlian
import com.makeramen.roundedimageview.RoundedImageView

class KeahlianAdapter (
    private val data : List<Keahlian>
) : RecyclerView.Adapter<KeahlianAdapter.KeahlianViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeahlianViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_slider_keahlian_profile_guru,
            parent, false)

        return KeahlianViewHolder(v)
    }

    override fun onBindViewHolder(holder: KeahlianViewHolder, position: Int) {
        val keahlian = data[position]
        holder.tvKeahlian.text = keahlian.tvKeahlian
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class KeahlianViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val tvKeahlian : TextView = itemView.findViewById(R.id.tv_keahlian_profile_guru)
    }
}