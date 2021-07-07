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

class BidangStudiAdapter (
    private val data: List<BidangStudi>,
    private val listener : OnItemClickListener,
) : RecyclerView.Adapter<BidangStudiAdapter.BidangStudiViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BidangStudiAdapter.BidangStudiViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_bidang_studi,
            parent,false)

        return BidangStudiViewHolder(v)
    }

    override fun onBindViewHolder(holder: BidangStudiAdapter.BidangStudiViewHolder, position: Int) {
        val bidangStudi = data[position]
        holder.imGambarMapel.setImageResource(bidangStudi.gambarMapel)
        holder.tvNamaMapel.text = bidangStudi.namaMapel
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class BidangStudiViewHolder
    internal constructor(
        itemView : View
    ) : RecyclerView.ViewHolder(itemView){
        val imGambarMapel : ImageView = itemView.findViewById(R.id.im_bidang_studi)
        val tvNamaMapel : TextView = itemView.findViewById(R.id.tv_nama_bidang_studi)
    }

}