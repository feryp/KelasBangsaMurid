package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.Ulasan
import de.hdodenhof.circleimageview.CircleImageView

class UlasanAdapter (
    private val data : List<Ulasan>,
) : RecyclerView.Adapter<UlasanAdapter.UlasanViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UlasanAdapter.UlasanViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_ulasan_murid,
            parent, false)

        return UlasanViewHolder(v)
    }

    override fun onBindViewHolder(holder: UlasanAdapter.UlasanViewHolder, position: Int) {
        val ulasan = data[position]
        holder.imFotoMurid.setImageResource(ulasan.fotoMurid)
        holder.tvNamaMurid.text = ulasan.namaMurid
        holder.tvKomentarMurid.text = ulasan.komentarMurid
        holder.tvRatingMurid.text = ulasan.ratingMurid
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class UlasanViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imFotoMurid : CircleImageView = itemView.findViewById(R.id.foto_murid_ulasan)
        val tvNamaMurid : TextView = itemView.findViewById(R.id.tv_nama_murid_ulasan)
        val tvKomentarMurid : TextView = itemView.findViewById(R.id.tv_komentar_ulasan)
        val tvRatingMurid : TextView = itemView.findViewById(R.id.tv_rating_ulasan)

    }
}