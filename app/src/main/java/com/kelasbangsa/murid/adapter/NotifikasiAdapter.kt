package com.kelasbangsa.murid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.Notifikasi

class NotifikasiAdapter (
    private val context: Context,
    private val data: List<Notifikasi>
) : RecyclerView.Adapter<NotifikasiAdapter.NotifikasiViewHolder>(){

    private var listData: MutableList<Notifikasi> = data as MutableList<Notifikasi>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifikasiViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_notification,
            parent, false
        )
        return NotifikasiViewHolder(v)
    }

    override fun onBindViewHolder(holder: NotifikasiViewHolder, position: Int) {
        val notifikasi = data[position]
        val animation = AnimationUtils.loadAnimation(context, R.anim.fade_scale_animation)
        holder.tvTitle.text = notifikasi.title
        holder.tvSubTitle.text = notifikasi.subTitle
        holder.tvTime.text = notifikasi.time
        holder.viewForeground.animation = animation
        holder.viewBackground.animation = animation
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun removeItem(position: Int) {
        listData.removeAt(position)
        notifyItemRemoved(position)
    }

    fun restoreItem(item: Notifikasi, position: Int) {
        listData.add(position, item)
        notifyItemInserted(position)
    }


    inner class NotifikasiViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvTitle : TextView = itemView.findViewById(R.id.tv_title_notif)
        val tvSubTitle : TextView = itemView.findViewById(R.id.tv_subtitle_notif)
        val tvTime : TextView = itemView.findViewById(R.id.tv_waktu_notif)
        val viewForeground : LinearLayout = itemView.findViewById(R.id.container_card_notifikasi)
        val viewBackground : LinearLayout = itemView.findViewById(R.id.view_background)
    }
}