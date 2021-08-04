package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.Provinsi

class ProvinsiBotsheetAdapter (
    private val data : List<Provinsi>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<ProvinsiBotsheetAdapter.ProvinsiViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinsiViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list_botsheet,
            parent, false)

        return ProvinsiViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProvinsiViewHolder, position: Int) {
        holder.tvProvinsi.text = data[position].namaProvinsi
        holder.itemView.setOnClickListener{
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class ProvinsiViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvProvinsi : TextView = itemView.findViewById(R.id.tv_item_single_botsheet)

    }
}