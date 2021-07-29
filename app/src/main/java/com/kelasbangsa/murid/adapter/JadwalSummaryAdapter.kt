package com.kelasbangsa.murid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.JadwalSummary
import org.w3c.dom.Text

class JadwalSummaryAdapter (
    private val context: Context,
    private val data: List<JadwalSummary>
) : RecyclerView.Adapter<JadwalSummaryAdapter.JadwalSummaryViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalSummaryViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_jadwal_summary,
            parent, false
        )

        return JadwalSummaryViewHolder(v)
    }

    override fun onBindViewHolder(holder: JadwalSummaryViewHolder, position: Int) {
        val jadwalSummary = data[position]
        holder.tgl.text = jadwalSummary.tglSummary
        holder.jamMulai.text = jadwalSummary.jamMulaiSummary
        holder.jamSelesai.text = jadwalSummary.jamSelesaiSummary
    }

    override fun getItemCount(): Int {
        return data.size
    }




    inner class JadwalSummaryViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tgl : TextView = itemView.findViewById(R.id.tv_tgl_jadwal_summary)
        val jamMulai : TextView = itemView.findViewById(R.id.tv_jam_mulai_jadwal_summary)
        val jamSelesai : TextView =  itemView.findViewById(R.id.tv_jam_selesai_jadwal_summary)
    }

}