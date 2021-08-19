package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.TingkatPendidikan

class TingPendidikanBotSheetAdapter (
    private val data : List<TingkatPendidikan>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<TingPendidikanBotSheetAdapter.TingPendidikanViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TingPendidikanBotSheetAdapter.TingPendidikanViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list_botsheet,
            parent, false)

        return TingPendidikanViewHolder(v)
    }

    override fun onBindViewHolder(holder: TingPendidikanBotSheetAdapter.TingPendidikanViewHolder, position: Int) {
        val tingPendidikan = data[position]
        holder.tvTingPendidikan.text = tingPendidikan.tingkatPendidikan
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class TingPendidikanViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvTingPendidikan : TextView = itemView.findViewById(R.id.tv_item_single_botsheet)

    }

}