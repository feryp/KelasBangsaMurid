package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.PaketBelajar

class PaketProfileGuruAdapter (
    private val data: List<PaketBelajar>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<PaketProfileGuruAdapter.PaketProfileViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaketProfileViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_paket_profile_guru,
            parent, false)

        return PaketProfileViewHolder(v)
    }

    override fun onBindViewHolder(holder: PaketProfileViewHolder, position: Int) {
        val paket = data[position]
        holder.tvNamaPaket.text = paket.namaPaket
        holder.tvTingPendidikan.text = paket.tingkatPendidikanPaket
        holder.tvTingKelas.text = paket.tingkatKelasPaket
        holder.tvJmlPertemuan.text = paket.jmlPertemuan
        holder.tvHarga.text = paket.hargaPaket
        holder.itemView.setOnClickListener{
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class PaketProfileViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvNamaPaket : TextView = itemView.findViewById(R.id.tv_nama_paket_belajar)
        val tvTingPendidikan : TextView = itemView.findViewById(R.id.tv_tingkat_pendidikan_paket_belajar)
        val tvTingKelas : TextView = itemView.findViewById(R.id.tv_tingkat_kelas_paket_belajar)
        val tvJmlPertemuan : TextView = itemView.findViewById(R.id.tv_jumlah_pertemuan_paket_belajar)
        val tvHarga : TextView = itemView.findViewById(R.id.tv_harga_paket_belajar)
    }
}