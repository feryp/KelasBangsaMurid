package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.GuruFavorit
import com.makeramen.roundedimageview.RoundedImageView

class ListGuruFavoritAdapter (
    private val data : List<GuruFavorit>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<ListGuruFavoritAdapter.GuruFavoritViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListGuruFavoritAdapter.GuruFavoritViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_guru_favorit,
            parent, false)

        return GuruFavoritViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListGuruFavoritAdapter.GuruFavoritViewHolder, position: Int) {
        val guru = data[position]
        holder.imFotoGuru.setImageResource(guru.fotoGuru)
        holder.tvNamaGuru.text = guru.namaGuru
        holder.tvBSGuru.text = guru.bidangStudiGuru
        holder.tvTingPendidikanGuru.text = guru.tingPendidikanGuru
        holder.tvTingKelasGuru.text = guru.tingKelasGuru
        holder.tvAlamatGuru.text = guru.alamatGuru
        holder.tvRatingGuru.text = guru.ratingGuru
        holder.tvHargaGuru.text = guru.hargaGuru
        holder.itemView.setOnClickListener{
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class GuruFavoritViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val imFotoGuru : RoundedImageView = itemView.findViewById(R.id.im_foto_guru_favorit)
        val tvNamaGuru : TextView = itemView.findViewById(R.id.tv_nama_guru_favorit)
        val tvBSGuru : TextView = itemView.findViewById(R.id.tv_bidang_studi_guru_favorit)
        val tvTingPendidikanGuru : TextView = itemView.findViewById(R.id.tv_ting_pendidikan_guru_favorit)
        val tvTingKelasGuru : TextView = itemView.findViewById(R.id.tv_ting_kelas_guru_favorit)
        val tvAlamatGuru : TextView = itemView.findViewById(R.id.tv_alamat_guru_favorit)
        val tvRatingGuru : TextView = itemView.findViewById(R.id.tv_rating_guru_favorit)
        val tvHargaGuru : TextView = itemView.findViewById(R.id.tv_harga_guru_favorit)
        val btnPilih : MaterialButton = itemView.findViewById(R.id.btn_pilih_list_guru_favorit)

    }


}