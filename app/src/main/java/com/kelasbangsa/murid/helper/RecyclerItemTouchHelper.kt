package com.kelasbangsa.murid.helper

import android.graphics.Canvas
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.`interface`.RecyclerItemTouchListener
import com.kelasbangsa.murid.adapter.NotifikasiAdapter

class RecyclerItemTouchHelper(
    dragDirs: Int,
    swipeDirs: Int,
    private var listener: RecyclerItemTouchListener
) :
    ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        listener.onSwiped(viewHolder, direction, viewHolder.adapterPosition)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        val foregroundView: View = (viewHolder as NotifikasiAdapter.NotifikasiViewHolder).viewForeground
        getDefaultUIUtil().clearView(foregroundView)
    }

    override fun convertToAbsoluteDirection(flags: Int, layoutDirection: Int): Int {
        return super.convertToAbsoluteDirection(flags, layoutDirection)
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        if (viewHolder != null) {
            val foregroundView: View = (viewHolder as NotifikasiAdapter.NotifikasiViewHolder).viewForeground
            getDefaultUIUtil().onSelected(foregroundView)
        }
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val foregroundView: View = (viewHolder as NotifikasiAdapter.NotifikasiViewHolder).viewForeground
        getDefaultUIUtil().onDraw(
            c,
            recyclerView,
            foregroundView,
            dX,
            dY,
            actionState,
            isCurrentlyActive
        )
    }

    override fun onChildDrawOver(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val foregroundView: View = (viewHolder as NotifikasiAdapter.NotifikasiViewHolder).viewForeground
        getDefaultUIUtil().onDrawOver(
            c,
            recyclerView,
            foregroundView,
            dX,
            dY,
            actionState,
            isCurrentlyActive
        )
    }

}