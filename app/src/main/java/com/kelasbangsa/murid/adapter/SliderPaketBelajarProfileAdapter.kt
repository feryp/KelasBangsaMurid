package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.PaketBelajar
import de.hdodenhof.circleimageview.CircleImageView

class SliderPaketBelajarProfileAdapter (
    private val data: List<PaketBelajar>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<SliderPaketBelajarProfileAdapter.SliderPaketProfileViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderPaketProfileViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_slider_paket_profile_guru,
            parent, false)

        return SliderPaketProfileViewHolder(v)
    }

    override fun onBindViewHolder(holder: SliderPaketProfileViewHolder, position: Int) {
        val paket = data[position]
        holder.tvNamaPaket.text = paket.namaPaket
        holder.tvTingPendidikan.text = paket.tingkatPendidikanPaket
        holder.tvTingKelas.text = paket.tingkatKelasPaket
        holder.tvJmlPertemuan.text = paket.jmlPertemuan
        holder.tvHarga.text = paket.hargaPaket
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class SliderPaketProfileViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val tvNamaPaket : TextView = itemView.findViewById(R.id.tv_nama_paket_belajar_profile)
        val tvTingPendidikan : TextView = itemView.findViewById(R.id.tv_tingkat_pendidikan_paket_belajar_profile)
        val tvTingKelas : TextView = itemView.findViewById(R.id.tv_tingkat_kelas_paket_belajar_profile)
        val tvJmlPertemuan : TextView = itemView.findViewById(R.id.tv_jumlah_pertemuan_paket_belajar_profile)
        val tvHarga : TextView = itemView.findViewById(R.id.tv_harga_paket_belajar_profile)
    }
}