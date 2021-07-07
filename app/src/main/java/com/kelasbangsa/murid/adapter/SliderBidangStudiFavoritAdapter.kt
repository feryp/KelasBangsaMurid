package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.BidangStudi

class SliderBidangStudiFavoritAdapter (
    private val data: List<BidangStudi>
) : RecyclerView.Adapter<SliderBidangStudiFavoritAdapter.SliderBidangStudiFavoritViewHolder>(){

    private val items : MutableList<CardView>

    init {
        this.items = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderBidangStudiFavoritViewHolder {
       val v : View = LayoutInflater.from(parent.context).inflate(
           R.layout.item_slider_bidang_studi_favorit,
           parent,false)

        return SliderBidangStudiFavoritViewHolder(v)
    }

    override fun onBindViewHolder(holder: SliderBidangStudiFavoritViewHolder, position: Int) {
        holder.imGambarMapel.setImageResource(data.get(position).gambarMapel)
        holder.tvNamaMapel.text = data[position].namaMapel

        items.add(holder.card)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class SliderBidangStudiFavoritViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val imGambarMapel : ImageView = itemView.findViewById(R.id.im_bs_favorit)
        val tvNamaMapel : TextView = itemView.findViewById(R.id.tv_nama_bs_favorit)
        val card : CardView = itemView.findViewById(R.id.card_bs_favorit)
    }


}