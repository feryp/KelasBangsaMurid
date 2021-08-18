package com.kelasbangsa.murid.ui.riwayat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.ListGuruAdapter
import com.kelasbangsa.murid.adapter.RiwayatKelasAdapter
import com.kelasbangsa.murid.data.model.RiwayatKelas

class RiwayatKelasActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var rvRiwayat : RecyclerView
    private lateinit var riwayat : MutableList<RiwayatKelas>
    private lateinit var adapterRiwayat : RiwayatKelasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat_kelas)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_riwayat_kelas)
        rvRiwayat = findViewById(R.id.rv_riwayat_kelas)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        //List Riwayat
        riwayat = ArrayList()
        for (i : Int in 1..50)
            riwayat.add(
                RiwayatKelas(
                    R.drawable.foto_example,
                "Wiwin S, S.pd",
                "06 Sep 2020, 16:35 WIB",
                "Cara belajarnya seru ga ngebosenin, dan mudah di mengerti...",
                "Terima Kasih",
                "Rp 100.000",
                "Selesai")
            )

        //Set adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterRiwayat = RiwayatKelasAdapter(riwayat, this)
        rvRiwayat.adapter = adapterRiwayat
        rvRiwayat.layoutManager = layoutManager
        rvRiwayat.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Pilih "+riwayat[position].namaGuru, Toast.LENGTH_SHORT).show()
        val detailRiwayat = Intent(this, DetailRiwayatActivity::class.java)
        startActivity(detailRiwayat)
    }
}