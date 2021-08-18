package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.RiwayatKelas
import de.hdodenhof.circleimageview.CircleImageView

class RiwayatKelasAdapter (
    private val data : List<RiwayatKelas>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<RiwayatKelasAdapter.RiwayatKelasViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatKelasAdapter.RiwayatKelasViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_riwayat_kelas,
            parent,false)

        return RiwayatKelasViewHolder(v)
    }

    override fun onBindViewHolder(holder: RiwayatKelasAdapter.RiwayatKelasViewHolder, position: Int) {
        val riwayatKelas = data[position]
        holder.imFotoGuru.setImageResource(riwayatKelas.fotoGuru)
        holder.tvNamaGuru.text = riwayatKelas.namaGuru
        holder.tvWaktuTransaksi.text = riwayatKelas.waktuTransaksi
        holder.tvUlasan.text = riwayatKelas.ulasan
        holder.tvBalasan.text = riwayatKelas.balasan
        holder.tvTotalHarga.text = riwayatKelas.totalHarga
        holder.tvStatusTransaksi.text = riwayatKelas.statusTransaksi
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class RiwayatKelasViewHolder internal constructor(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imFotoGuru : CircleImageView = itemView.findViewById(R.id.foto_guru_riwayat)
        val tvNamaGuru : TextView = itemView.findViewById(R.id.tv_nama_guru_riwayat)
        val tvWaktuTransaksi : TextView = itemView.findViewById(R.id.tv_waktu_selesai_transaksi_riwayat)
        val tvUlasan : TextView = itemView.findViewById(R.id.tv_ulasan_riwayat)
        val tvBalasan : TextView = itemView.findViewById(R.id.tv_balasan_ulasan_riwayat)
        val tvTotalHarga : TextView = itemView.findViewById(R.id.tv_total_harga_riwayat)
        val tvStatusTransaksi : TextView = itemView.findViewById(R.id.tv_status_selesai_riwayat)
    }
}