package com.kelasbangsa.murid.ui.paketBelajar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.PaketBelajarAdapter
import com.kelasbangsa.murid.adapter.SliderPaketBelajarAdapter
import com.kelasbangsa.murid.data.model.PaketBelajar
import com.kelasbangsa.murid.ui.filter.FilterGuruActivity
import com.kelasbangsa.murid.ui.guru.ProfileGuruActivity

class PaketBelajarActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var rvPaketBelajar : RecyclerView
    private lateinit var paket : MutableList<PaketBelajar>
    private lateinit var adapterPaket : PaketBelajarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paket_belajar)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_paket_belajar)
        rvPaketBelajar = findViewById(R.id.rv_paket_belajar)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        toolbar.setOnMenuItemClickListener{menuItem ->
            when(menuItem.itemId){
                R.id.menu_filter -> {
                    val filter = Intent(this, FilterPaketBelajarActivity::class.java)
                    startActivity(filter)
                    true
                }
                else -> false
            }
        }

        //List Paket Belajar
        paket = ArrayList()
        for (i : Int in 1..50)
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
                    R.drawable.foto_example,
                    "Wiwin S, S.pd",
                    "",
                    "Rp 40.000"
                )
            )

        //set adapter paket belajar
        val layoutManagerPaket = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterPaket = PaketBelajarAdapter(paket, this)
        rvPaketBelajar.layoutManager = layoutManagerPaket
        rvPaketBelajar.setHasFixedSize(true)
        rvPaketBelajar.adapter = adapterPaket
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Pilih "+paket[position].namaPaket, Toast.LENGTH_SHORT).show()
        val detailPaket = Intent(this, DetailPaketActivity::class.java)
        intent.putExtra("nama", paket[position].namaPaket)
        startActivity(detailPaket)
    }
}