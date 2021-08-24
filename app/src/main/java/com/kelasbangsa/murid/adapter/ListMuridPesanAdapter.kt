package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.ListMurid
import de.hdodenhof.circleimageview.CircleImageView

class ListMuridPesanAdapter (
    private val data : List<ListMurid>
) : RecyclerView.Adapter<ListMuridPesanAdapter.ListMuridViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMuridPesanAdapter.ListMuridViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_jadwal_dipesan,
            parent, false)

        return ListMuridViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListMuridPesanAdapter.ListMuridViewHolder, position: Int) {
        val jadwal = data[position]
        holder.imFotoMurid.setImageResource(jadwal.fotoMurid)
        holder.tvTgl.text = jadwal.tgl
        holder.tvJamMulai.text = jadwal.jamMulai
        holder.tvJamSelesai.text = jadwal.jamSelesai
        holder.tvAlamat.text = jadwal.alamat
        holder.tvStatus.text = jadwal.status
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class ListMuridViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val imFotoMurid : CircleImageView = itemView.findViewById(R.id.foto_murid_dipesan)
        val tvTgl : TextView = itemView.findViewById(R.id.tv_tgl_dipesan)
        val tvJamMulai : TextView = itemView.findViewById(R.id.tv_jam_mulai_dipesan)
        val tvJamSelesai : TextView = itemView.findViewById(R.id.tv_jam_selesai_dipesan)
        val tvAlamat : TextView = itemView.findViewById(R.id.tv_lokasi_alamat_dipesan)
        val tvStatus : TextView = itemView.findViewById(R.id.tv_status_telah_dipesan)
    }
}