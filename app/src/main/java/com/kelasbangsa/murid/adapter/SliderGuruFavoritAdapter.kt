package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.GuruFavorit
import de.hdodenhof.circleimageview.CircleImageView

class SliderGuruFavoritAdapter (
    private val  data: List<GuruFavorit>
) : RecyclerView.Adapter<SliderGuruFavoritAdapter.SliderGuruFavoritViewHolder>(){

    private val items : MutableList<LinearLayout>

    init {
        this.items  = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderGuruFavoritViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_slider_guru_favorit,
            parent, false)

        return SliderGuruFavoritViewHolder(v)
    }

    override fun onBindViewHolder(holder: SliderGuruFavoritViewHolder, position: Int) {
        holder.imFotoGuru.setImageResource(data.get(position).fotoGuru)
        holder.tvNamaGuru.text = data[position].namaGuru

        items.add(holder.listGuru)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    inner class SliderGuruFavoritViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val imFotoGuru : CircleImageView = itemView.findViewById(R.id.foto_guru_favorit)
        val tvNamaGuru : TextView = itemView.findViewById(R.id.tv_nama_guru_favorit)
        val listGuru : LinearLayout = itemView.findViewById(R.id.item_guru_favorit)
    }
}