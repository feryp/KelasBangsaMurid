package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.Galeri
import com.makeramen.roundedimageview.RoundedImageView

class GaleriAdapter (
    private val data : List<Galeri>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<GaleriAdapter.GaleriViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GaleriAdapter.GaleriViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_galeri_profile_guru,
            parent, false)

        return GaleriViewHolder(v)
    }

    override fun onBindViewHolder(holder: GaleriAdapter.GaleriViewHolder, position: Int) {
        val galeri = data[position]
        holder.imFotoGaleri.setImageResource(galeri.fotoGaleri)
        holder.itemView.setOnClickListener{
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class GaleriViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val imFotoGaleri : RoundedImageView = itemView.findViewById(R.id.im_foto_galeri_grid_guru)
    }


}