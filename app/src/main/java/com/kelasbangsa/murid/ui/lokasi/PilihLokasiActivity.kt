package com.kelasbangsa.murid.ui.lokasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.LinearLayoutCompat
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R

class PilihLokasiActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var btnPilihPeta : LinearLayoutCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_lokasi)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_pilih_lokasi)
        btnPilihPeta = findViewById(R.id.container_pilih_lewat_peta)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        btnPilihPeta.setOnClickListener {
            //open google maps
        }


    }
}