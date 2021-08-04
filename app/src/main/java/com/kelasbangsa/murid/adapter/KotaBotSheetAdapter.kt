package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.Kota

class KotaBotSheetAdapter (
    private val data : List<Kota>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<KotaBotSheetAdapter.KotaViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KotaViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list_botsheet,
            parent, false)

        return KotaViewHolder(v)
    }

    override fun onBindViewHolder(holder: KotaViewHolder, position: Int) {
        holder.tvKota.text = data[position].namaKota
        holder.itemView.setOnClickListener{
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class KotaViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvKota : TextView = itemView.findViewById(R.id.tv_item_single_botsheet)

    }
}