package com.kelasbangsa.murid

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.kelasbangsa.murid.`interface`.RecyclerItemTouchListener
import com.kelasbangsa.murid.adapter.NotifikasiAdapter
import com.kelasbangsa.murid.helper.RecyclerItemTouchHelper
import com.kelasbangsa.murid.model.Notifikasi

class NotifikasiActivity : AppCompatActivity(), RecyclerItemTouchListener {

    private lateinit var btnBack : ImageButton
    private lateinit var rvNotifikasi : RecyclerView
    private lateinit var adapterNotifikasi : NotifikasiAdapter
    private lateinit var notifikasi : MutableList<Notifikasi>
    private lateinit var rootLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifikasi)

        //INIT VIEW
        btnBack = findViewById(R.id.btn_back)
        rvNotifikasi = findViewById(R.id.rv_notifikasi)
        rootLayout = findViewById(R.id.layout_notifikasi)

        //List Notifikasi
        notifikasi = ArrayList()
        for (i : Int in 1..50)
            notifikasi.add(
                Notifikasi(
                    "Penarikan Sukses",
                    "Penarikan saldo anda telah berhasil di terima oleh admin, segera cek rekening anda. Terima kasih :)",
                    "20 November 2020 10:12 AM"
                )
            )

        //Set adapter notifikasi
        val layoutManagerNotifikasi = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        adapterNotifikasi = NotifikasiAdapter(this, notifikasi)
        rvNotifikasi.layoutManager = layoutManagerNotifikasi
        rvNotifikasi.adapter = adapterNotifikasi
        rvNotifikasi.setHasFixedSize(true)

        btnBack.setOnClickListener {
            finish()
        }

        val itemTouchHelperCallBack: ItemTouchHelper.SimpleCallback =
            RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this)
        ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(rvNotifikasi)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {
        if (viewHolder is NotifikasiAdapter.NotifikasiViewHolder) {
            val title: String = notifikasi.get(viewHolder.adapterPosition).title
            val deleteItem: Notifikasi = notifikasi.get(viewHolder.adapterPosition)
            val deleteIndex = viewHolder.adapterPosition
            adapterNotifikasi.removeItem(deleteIndex)
            val snackbar = Snackbar.make(
                rootLayout,
                "$title Dihapus! ",
                Snackbar.LENGTH_LONG
            )
            snackbar.setAction(
                "UNDO"
            ) { adapterNotifikasi.restoreItem(deleteItem, deleteIndex) }
            snackbar.setActionTextColor(Color.RED)
            snackbar.show()
        }
    }
}