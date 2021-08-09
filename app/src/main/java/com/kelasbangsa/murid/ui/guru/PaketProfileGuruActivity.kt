package com.kelasbangsa.murid.ui.guru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.PaketProfileGuruAdapter
import com.kelasbangsa.murid.adapter.SliderPaketBelajarProfileAdapter
import com.kelasbangsa.murid.data.model.PaketBelajar

class PaketProfileGuruActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var rvPaket : RecyclerView
    private lateinit var paket : MutableList<PaketBelajar>
    private lateinit var adapterPaket : PaketProfileGuruAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paket_profile_guru)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_paket_profile)
        rvPaket = findViewById(R.id.rv_paket_profile_guru)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        paket = ArrayList()
        for (i : Int in 1..10)
            paket.add(
                PaketBelajar(
                    "Paket Matematika Dua",
                    "",
                    "",
                    "SMA",
                    "Kelas 10",
                    "2 Pertemuan",
                    "",
                    "",
                    "",
                    0,
                    0,
                    0,
                    "",
                    "",
                    "Rp 40.000"

                )
            )

        //Set adapter
        val layoutManagerPaket = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterPaket = PaketProfileGuruAdapter(paket,this)
        rvPaket.adapter = adapterPaket
        rvPaket.layoutManager = layoutManagerPaket
        rvPaket.setHasFixedSize(true)

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Pilih "+paket[position].namaPaket, Toast.LENGTH_SHORT).show()
    }
}