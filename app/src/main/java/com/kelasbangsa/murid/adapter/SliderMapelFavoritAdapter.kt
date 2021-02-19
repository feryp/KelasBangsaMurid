package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.model.MataPelajaran

class SliderMapelFavoritAdapter (
    private val data: List<MataPelajaran>
) : RecyclerView.Adapter<SliderMapelFavoritAdapter.SliderMapelFavoritViewHolder>(){

    private val items : MutableList<CardView>

    init {
        this.items = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderMapelFavoritViewHolder {
       val v : View = LayoutInflater.from(parent.context).inflate(
           R.layout.item_slider_mata_pelajaran_favorit,
           parent,false)

        return SliderMapelFavoritViewHolder(v)
    }

    override fun onBindViewHolder(holder: SliderMapelFavoritViewHolder, position: Int) {
        holder.imGambarMapel.setImageResource(data.get(position).gambarMapel)
        holder.tvNamaMapel.text = data[position].namaMapel

        items.add(holder.card)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class SliderMapelFavoritViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val imGambarMapel : ImageView = itemView.findViewById(R.id.im_mapel_favorit)
        val tvNamaMapel : TextView = itemView.findViewById(R.id.tv_nama_mapel_favorit)
        val card : CardView = itemView.findViewById(R.id.card_mapel_favorit)
    }


}