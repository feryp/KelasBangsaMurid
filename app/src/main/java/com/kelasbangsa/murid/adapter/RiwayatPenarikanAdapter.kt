package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.RiwayatPenarikan

class RiwayatPenarikanAdapter (
    private val data : List<RiwayatPenarikan>
) : RecyclerView.Adapter<RiwayatPenarikanAdapter.RiwayatPenarikanViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatPenarikanViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_riwayat_penarikan,
            parent, false)

        return RiwayatPenarikanViewHolder(v)
    }

    override fun onBindViewHolder(holder: RiwayatPenarikanViewHolder, position: Int) {
        val penarikanSaldo = data[position]
        holder.tvWaktuPenarikan.text = penarikanSaldo.waktuPenarikan
        holder.tvJumlahPenarikan.text = penarikanSaldo.jumlahPenarikan
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class RiwayatPenarikanViewHolder internal constructor(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tvWaktuPenarikan : TextView = itemView.findViewById(R.id.tv_waktu_penarikan)
        val tvJumlahPenarikan : TextView = itemView.findViewById(R.id.tv_jumlah_penarikan)
    }
}