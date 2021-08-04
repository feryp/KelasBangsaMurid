package com.kelasbangsa.murid.ui.guru

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
import com.kelasbangsa.murid.data.model.Guru
import com.kelasbangsa.murid.ui.Tingkatan.TingkatPendidikanActivity
import com.kelasbangsa.murid.ui.ubahAkun.UbahAkunActivity

class GuruActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var rvGuru : RecyclerView
    private lateinit var guru : MutableList<Guru>
    private lateinit var adapterGuru : ListGuruAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guru)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_guru)
        rvGuru = findViewById(R.id.rv_guru)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        toolbar.setOnMenuItemClickListener{menuItem ->
            when(menuItem.itemId){
                R.id.menu_filter -> {
                    val filter = Intent(this, FilterGuruActivity::class.java)
                    startActivity(filter)
                    true
                }
                else -> false
            }
        }


        //List guru
        guru = ArrayList()
        for (i : Int in 1..50)
            guru.add(
                Guru(
                    R.drawable.foto_example,
                    "Wiwin S, S.pd",
                    "Matematika",
                    "Kecamatan Kelapa Gading, Kota Jakarta Utara",
                    "4.6",
                    "Rp 45.000",
                    "Rp 20.000"
                )
            )


        //Set adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterGuru = ListGuruAdapter(guru, this)
        rvGuru.adapter = adapterGuru
        rvGuru.layoutManager = layoutManager
        rvGuru.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Pilih "+guru[position].namaGuru, Toast.LENGTH_SHORT).show()
        val profileGuru = Intent(this, ProfileGuruActivity::class.java)
        intent.putExtra("nama", guru[position].namaGuru)
        startActivity(profileGuru)
    }
}