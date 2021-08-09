package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.Galeri
import com.makeramen.roundedimageview.RoundedImageView

class SliderGaleriAdapter (
    private val data : List<Galeri>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<SliderGaleriAdapter.SliderGaleriViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderGaleriViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_slider_galeri_profile_guru,
            parent, false)

        return SliderGaleriViewHolder(v)
    }

    override fun onBindViewHolder(holder: SliderGaleriViewHolder, position: Int) {
        val galeri = data[position]
        holder.imFotoGaleri.setImageResource(galeri.fotoGaleri)
        holder.itemView.setOnClickListener{
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class SliderGaleriViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val imFotoGaleri : RoundedImageView = itemView.findViewById(R.id.im_foto_galeri_guru)
    }
}