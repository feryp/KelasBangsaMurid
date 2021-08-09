package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.PaketBelajar
import de.hdodenhof.circleimageview.CircleImageView

class SliderPaketBelajarAdapter(
    private val data: List<PaketBelajar>
) : RecyclerView.Adapter<SliderPaketBelajarAdapter.SliderPaketBelajarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderPaketBelajarViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_slider_paket_belajar,
            parent, false)

        return SliderPaketBelajarViewHolder(v)
    }

    override fun onBindViewHolder(holder: SliderPaketBelajarViewHolder, position: Int) {
        holder.tvNamaPaket.text = data[position].namaPaket
        holder.tvTingPendidikan.text = data[position].tingkatPendidikanPaket
        holder.tvTingKelas.text = data[position].tingkatKelasPaket
        holder.tvJmlPertemuan.text = data[position].jmlPertemuan
        holder.imFotoGuru.setImageResource(data.get(position).fotoGuru)
        holder.tvNamaGuru.text = data[position].namaGuru
        holder.tvHarga.text = data[position].hargaPaket

    }


    override fun getItemCount(): Int {
        return data.size
    }

    inner class SliderPaketBelajarViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val tvNamaPaket : TextView = itemView.findViewById(R.id.tv_nama_paket)
        val tvTingPendidikan : TextView = itemView.findViewById(R.id.tv_tingkat_pendidikan_paket)
        val tvTingKelas : TextView = itemView.findViewById(R.id.tv_tingkat_kelas_paket)
        val tvJmlPertemuan : TextView = itemView.findViewById(R.id.tv_jumlah_pertemuan_paket)
        val imFotoGuru : CircleImageView = itemView.findViewById(R.id.foto_guru_paket)
        val tvNamaGuru : TextView = itemView.findViewById(R.id.tv_nama_guru_paket)
        val tvHarga : TextView = itemView.findViewById(R.id.tv_harga_paket)
    }

}