package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.BidangStudi

class SliderBidangStudiAdapter (
    private val data: List<BidangStudi>,
    private val listener : OnItemClickListener,
) : RecyclerView.Adapter<SliderBidangStudiAdapter.SliderBidangStudiViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderBidangStudiViewHolder {
       val v : View = LayoutInflater.from(parent.context).inflate(
           R.layout.item_slider_bidang_studi_favorit,
           parent,false)

        return SliderBidangStudiViewHolder(v)
    }

    override fun onBindViewHolder(holder: SliderBidangStudiViewHolder, position: Int) {
        val bidangStudi = data[position]
        holder.imGambarMapel.setImageResource(bidangStudi.gambarMapel)
        holder.tvNamaMapel.text = bidangStudi.namaMapel

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class SliderBidangStudiViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val imGambarMapel : ImageView = itemView.findViewById(R.id.im_bs_favorit)
        val tvNamaMapel : TextView = itemView.findViewById(R.id.tv_nama_bs_favorit)
    }

}