package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.Kategori

class KategoriBotSheetAdapter (
    private val data : List<Kategori>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<KategoriBotSheetAdapter.KategoriViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriBotSheetAdapter.KategoriViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list_botsheet,
            parent, false)

        return  KategoriViewHolder(v)
    }

    override fun onBindViewHolder(holder: KategoriBotSheetAdapter.KategoriViewHolder, position: Int) {
        val kategori = data[position]
        holder.tvNamaKategori.text = kategori.namaKategori
        holder.itemView.setOnClickListener{
            listener.onItemClick(position)
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class KategoriViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvNamaKategori : TextView = itemView.findViewById(R.id.tv_item_single_botsheet)

    }

}