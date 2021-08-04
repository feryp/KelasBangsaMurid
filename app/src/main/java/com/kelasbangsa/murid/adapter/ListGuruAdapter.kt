package com.kelasbangsa.murid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.Guru
import com.makeramen.roundedimageview.RoundedImageView

class ListGuruAdapter (
    private val data : List<Guru>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<ListGuruAdapter.GuruViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuruViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_guru,
            parent, false)

        return GuruViewHolder(v)
    }

    override fun onBindViewHolder(holder: GuruViewHolder, position: Int) {
        val guru = data[position]
        holder.imFotoGuru.setImageResource(guru.fotoGuru)
        holder.tvNamaGuru.text = guru.namaGuru
        holder.tvBSGuru.text = guru.bidangStudiGuru
        holder.tvAlamatGuru.text = guru.alamatGuru
        holder.tvRatingGuru.text = guru.ratingGuru
        holder.tvHargaBaru.text = guru.hargaBaru
        holder.tvHargaLama.text = guru.hargaLama
        holder.itemView.setOnClickListener{
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class GuruViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val imFotoGuru : RoundedImageView = itemView.findViewById(R.id.im_foto_guru)
        val tvNamaGuru : TextView = itemView.findViewById(R.id.tv_nama_guru)
        val tvBSGuru : TextView = itemView.findViewById(R.id.tv_bidang_studi_guru)
        val tvAlamatGuru : TextView = itemView.findViewById(R.id.tv_alamat_guru)
        val tvRatingGuru : TextView = itemView.findViewById(R.id.tv_rating_guru)
        val tvHargaLama : TextView = itemView.findViewById(R.id.tv_harga_lama_guru)
        val tvHargaBaru : TextView = itemView.findViewById(R.id.tv_harga_baru_guru)
        val btnPilih : MaterialButton = itemView.findViewById(R.id.btn_pilih_list_guru)

    }

}