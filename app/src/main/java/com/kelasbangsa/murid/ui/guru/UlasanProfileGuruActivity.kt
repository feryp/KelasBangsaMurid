package com.kelasbangsa.murid.ui.guru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.adapter.ListGuruAdapter
import com.kelasbangsa.murid.adapter.UlasanAdapter
import com.kelasbangsa.murid.data.model.Ulasan

class UlasanProfileGuruActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var rvUlasan : RecyclerView
    private lateinit var ulasan : MutableList<Ulasan>
    private lateinit var adapterUlasan : UlasanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ulasan_profile_guru)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_ulasan)
        rvUlasan = findViewById(R.id.rv_ulasan_murid)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        //List Ulasan
        ulasan = ArrayList()
        for (i : Int in 1..12)
            ulasan.add(
                Ulasan(
                R.drawable.foto_example,
                    "John Doe",
                    "Orangnya sangat baik, dan tidak galak, pokoknya rekomen banget deh ...",
                    "4.5"
                )
            )

        //Set adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterUlasan = UlasanAdapter(ulasan)
        rvUlasan.adapter = adapterUlasan
        rvUlasan.layoutManager = layoutManager
        rvUlasan.setHasFixedSize(true)
    }
}