package com.kelasbangsa.murid.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.data.model.BidangStudi

class SliderBSProfileGuruAdapter (
    private val data : List<BidangStudi>,
    private val listener : OnItemClickListener,
    var selectedBidangStudi: BidangStudi? = null
) : RecyclerView.Adapter<SliderBSProfileGuruAdapter.SliderBSProfileViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderBSProfileViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_slider_bs_profile_guru,
            parent,false)

        return SliderBSProfileViewHolder(v)
    }

    override fun onBindViewHolder(holder: SliderBSProfileViewHolder, position: Int) {
        val bidangStudi = data[position]
        holder.tvNamaBS.text = bidangStudi.namaMapel
        holder.itemView.setOnClickListener{
            listener.onItemClick(position)
        }

//        if (selectedBidangStudi?.namaMapel === bidangStudi.namaMapel
//        ) {
//            holder.tvNamaBS.setTextColor(Color.parseColor("#FFFFFF")) //warna putih
//            holder.container.setBackgroundResource(R.drawable.bg_buttton_red)
//        } else {
//            holder.tvNamaBS.setTextColor(Color.parseColor("#C8232C")) //warna hitam
//            holder.container.setBackgroundResource(R.drawable.bg_card_border_red)
//        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun getItem(position: Int): BidangStudi? {
        return data.get(position)
    }

//    fun selectCategory(selected: BidangStudi) {
//        selectedBidangStudi = selected
//        notifyDataSetChanged()
//    }
//
//    fun selectCategory(position: Int) {
//        selectCategory(getItem(position)!!)
//    }


    inner class SliderBSProfileViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val container : ConstraintLayout = itemView.findViewById(R.id.container_bs_profile_guru)
        val tvNamaBS : TextView = itemView.findViewById(R.id.tv_bs_profile_guru)
    }

}