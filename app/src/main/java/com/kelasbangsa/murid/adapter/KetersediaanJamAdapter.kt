package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.KetersediaanJam

class KetersediaanJamAdapter (
    private val data : List<KetersediaanJam>,
) : RecyclerView.Adapter<KetersediaanJamAdapter.KetersediaanJamViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KetersediaanJamAdapter.KetersediaanJamViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_ketersediaan_jam_guru,
            parent, false)

        return KetersediaanJamViewHolder(v)
    }

    override fun onBindViewHolder(holder: KetersediaanJamAdapter.KetersediaanJamViewHolder, position: Int) {
        val ketersediaan = data[position]
        holder.jamMulai.text = ketersediaan.ketersediaanJamMulai
        holder.jamSelesai.text = ketersediaan.ketersediaanJamSelesai
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class KetersediaanJamViewHolder internal constructor(itemView : View) : RecyclerView.ViewHolder(itemView){
        val jamMulai : TextView = itemView.findViewById(R.id.tv_jam_mulai_ketersediaan)
        val jamSelesai : TextView = itemView.findViewById(R.id.tv_jam_selesai_ketersediaan)

    }

}