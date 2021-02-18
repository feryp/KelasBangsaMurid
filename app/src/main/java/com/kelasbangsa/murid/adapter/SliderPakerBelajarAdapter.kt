package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.model.PaketBelajar
import de.hdodenhof.circleimageview.CircleImageView

class SliderPakerBelajarAdapter(
    private val data: List<PaketBelajar>
) : RecyclerView.Adapter<SliderPakerBelajarAdapter.SliderPaketBelajarViewHolder>() {

    private val items : MutableList<LinearLayout>

    init {
        this.items = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderPaketBelajarViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_slider_paket_belajar,
            parent, false)

        return SliderPaketBelajarViewHolder(v)
    }

    override fun onBindViewHolder(holder: SliderPaketBelajarViewHolder, position: Int) {
        holder.tvNamaPaket.text = data[position].namaPaket
        holder.tvTanggal.text = data[position].tglPaket
        holder.tvJamMulai.text = data[position].jamMulaiPaket
        holder.tvJamSelesai.text = data[position].jamSelesaiPaket
        holder.tvTingkatPendidikan.text = data[position].tingkatPendidikanPaket
        holder.tvPeserta.text = data[position].jumlahPesertaPaket.toString()
        holder.imFotoGuru.setImageResource(data.get(position).fotoGuru)
        holder.tvNamaGuru.text = data[position].namaGuru
        holder.tvAlamat.text = data[position].alamatPaket
        holder.tvHarga.text = data[position].hargaPaket

        items.add(holder.card)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class SliderPaketBelajarViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val tvNamaPaket : TextView = itemView.findViewById(R.id.tv_item_nama_paket)
        val tvTanggal : TextView = itemView.findViewById(R.id.tv_item_tgl_paket)
        val tvJamMulai : TextView = itemView.findViewById(R.id.tv_item_jam_mulai_paket)
        val tvJamSelesai : TextView = itemView.findViewById(R.id.tv_item_jam_selesai_paket)
        val tvTingkatPendidikan : TextView = itemView.findViewById(R.id.tv_item_tingkat_pendidikan_paket)
        val tvPeserta : TextView = itemView.findViewById(R.id.tv_item_peserta_paket)
        val imFotoGuru : CircleImageView = itemView.findViewById(R.id.foto_guru_paket)
        val tvNamaGuru : TextView = itemView.findViewById(R.id.tv_item_nama_guru_paket)
        val tvAlamat : TextView = itemView.findViewById(R.id.tv_item_alamat_paket)
        val tvHarga : TextView = itemView.findViewById(R.id.tv_item_harga_paket)
        val card : LinearLayout = itemView.findViewById(R.id.card_paket_belajar)
    }

}