package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.PaketBelajar
import de.hdodenhof.circleimageview.CircleImageView

class PaketBelajarAdapter (
    private val data : List<PaketBelajar>
) : RecyclerView.Adapter<PaketBelajarAdapter.PaketBelajarViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaketBelajarAdapter.PaketBelajarViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_paket_belajar,
            parent, false)

        return PaketBelajarViewHolder(v)
    }

    override fun onBindViewHolder(holder: PaketBelajarAdapter.PaketBelajarViewHolder, position: Int) {
        val paket = data[position]
        holder.tvNamaPaket.text = paket.namaPaket
        holder.tvTingPendidikan.text = paket.tingkatPendidikanPaket
        holder.tvTingKelas.text = paket.tingkatKelasPaket
        holder.tvJmlPertemuan.text = paket.jmlPertemuan
        holder.imFotoGuru.setImageResource(paket.fotoGuru)
        holder.tvNamaGuru.text = paket.namaGuru
        holder.tvHarga.text = paket.hargaPaket

    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class PaketBelajarViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val tvNamaPaket : TextView = itemView.findViewById(R.id.tv_nama_paket_belajar)
        val tvTingPendidikan : TextView = itemView.findViewById(R.id.tv_tingkat_pendidikan_paket_belajar)
        val tvTingKelas : TextView = itemView.findViewById(R.id.tv_tingkat_kelas_paket_belajar)
        val tvJmlPertemuan : TextView = itemView.findViewById(R.id.tv_jumlah_pertemuan_paket_belajar)
        val imFotoGuru : CircleImageView = itemView.findViewById(R.id.foto_guru_paket_belajar)
        val tvNamaGuru : TextView = itemView.findViewById(R.id.tv_nama_guru_paket_belajar)
        val tvHarga : TextView = itemView.findViewById(R.id.tv_harga_paket_belajar)
    }

}