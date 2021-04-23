package com.kelasbangsa.murid.`interface`

import androidx.recyclerview.widget.RecyclerView

interface RecyclerItemTouchListener {
    fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int)
}