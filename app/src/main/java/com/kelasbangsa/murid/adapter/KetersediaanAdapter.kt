package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.Ketersediaan

class KetersediaanAdapter (
    private val data : List<Ketersediaan>,
) : RecyclerView.Adapter<KetersediaanAdapter.KetersediaanViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KetersediaanAdapter.KetersediaanViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_ketersediaan,
            parent, false)

        return KetersediaanViewHolder(v)
    }

    override fun onBindViewHolder(holder: KetersediaanAdapter.KetersediaanViewHolder, position: Int) {
        val ketersediaan = data[position]
        holder.hari.text = ketersediaan.ketersediaanHari
        holder.jam.text = ketersediaan.ketersediaanJam
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class KetersediaanViewHolder internal constructor(itemView : View) : RecyclerView.ViewHolder(itemView){
        val hari : TextView = itemView.findViewById(R.id.tv_jadwal_hari_ketersediaan)
        val jam : TextView = itemView.findViewById(R.id.tv_jadwal_jam_ketersediaan)

    }

}