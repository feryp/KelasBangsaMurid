package com.kelasbangsa.murid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.MetodeBank

class MetodeBankAdapter (
    private val context: Context,
    private val data: List<MetodeBank>
) : RecyclerView.Adapter<MetodeBankAdapter.MetodeBankViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MetodeBankViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_metode_bank,
            parent, false
        )

        return MetodeBankViewHolder(v)
    }

    override fun onBindViewHolder(holder: MetodeBankViewHolder, position: Int) {
        val metodeBank = data[position]
        holder.logo.setImageResource(metodeBank.logoBank)
        holder.namaBank.text = metodeBank.namaBank

    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class MetodeBankViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val logo : AppCompatImageView = itemView.findViewById(R.id.logo_bank_item)
        val namaBank : TextView = itemView.findViewById(R.id.tv_nama_bank_item)
    }

}