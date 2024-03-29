package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.ItemClickListener
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.Kategori

class KategoriAdapter (
    private val data : List<Kategori>,
    private val listener : OnItemClickListener,
) : RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_kategori,
            parent, false)

        return KategoriViewHolder(v)
    }

    override fun onBindViewHolder(holder: KategoriViewHolder, position: Int) {
        val kategori = data[position]
        holder.icKategori.setImageResource(kategori.icKategori)
        holder.tvNamaKategori.text = kategori.namaKategori
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }


    override fun getItemCount(): Int {
       return data.size
    }


    inner class KategoriViewHolder internal constructor(itemView : View) : RecyclerView.ViewHolder(itemView){
        val icKategori : ImageView = itemView.findViewById(R.id.im_kategori_item)
        val tvNamaKategori : TextView = itemView.findViewById(R.id.tv_nama_kategori_item)

    }
}