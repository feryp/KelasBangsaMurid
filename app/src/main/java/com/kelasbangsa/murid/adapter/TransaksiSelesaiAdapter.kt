package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.Transaksi

class TransaksiSelesaiAdapter (
    private val data : List<Transaksi>,
    private val listener : OnItemClickListener,
) : RecyclerView.Adapter<TransaksiSelesaiAdapter.TransaksiSelesaiViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaksiSelesaiAdapter.TransaksiSelesaiViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_transaksi_selesai,
            parent,false)

        return TransaksiSelesaiViewHolder(v)
    }

    override fun onBindViewHolder(holder: TransaksiSelesaiAdapter.TransaksiSelesaiViewHolder, position: Int) {
        val transaksi = data[position]
        holder.tvKodeTransaksi.text = transaksi.kodeTransaksi
        holder.tvTglTransaksi.text = transaksi.tglTransaksi
        holder.tvTotalTransaksi.text = transaksi.totalTransaksi
        holder.tvStatusTransaksi.text = transaksi.statusTransaksi
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class TransaksiSelesaiViewHolder
    internal constructor(
        itemView : View
    ) : RecyclerView.ViewHolder(itemView){
        val tvKodeTransaksi : TextView = itemView.findViewById(R.id.tv_kode_transaksi_selesai)
        val tvTglTransaksi : TextView = itemView.findViewById(R.id.tv_tgl_transaksi_selesai)
        val tvTotalTransaksi : TextView = itemView.findViewById(R.id.tv_total_transaksi_selesai)
        val tvStatusTransaksi : TextView = itemView.findViewById(R.id.tv_status_transaksi_selesai)
    }

}