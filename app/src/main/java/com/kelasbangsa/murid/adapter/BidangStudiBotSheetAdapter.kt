package com.kelasbangsa.murid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.BidangStudi

class BidangStudiBotSheetAdapter (
    private val data : List<BidangStudi>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<BidangStudiBotSheetAdapter.BidangStudiViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BidangStudiBotSheetAdapter.BidangStudiViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list_botsheet,
            parent, false)

        return BidangStudiViewHolder(v)

    }

    override fun onBindViewHolder(holder: BidangStudiBotSheetAdapter.BidangStudiViewHolder, position: Int) {
        val bidangStudi = data[position]
        holder.tvNamaBidangStudi.text = bidangStudi.namaMapel
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class BidangStudiViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvNamaBidangStudi : TextView = itemView.findViewById(R.id.tv_item_single_botsheet)

    }

}