package com.kelasbangsa.murid.ui.guru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.GaleriAdapter
import com.kelasbangsa.murid.adapter.ListGuruAdapter
import com.kelasbangsa.murid.data.model.Galeri
import com.kelasbangsa.murid.ui.pesanKelas.PesanKelasActivity

class GaleriActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var rvGaleri : RecyclerView
    private lateinit var galeri : MutableList<Galeri>
    private lateinit var adapterGaleri : GaleriAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeri)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_galeri)
        rvGaleri = findViewById(R.id.rv_galeri)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        //List Galeri
        galeri = ArrayList()
        for (i : Int in 1..50)
            galeri.add(Galeri(R.drawable.foto_example))

        //Set adapter
        val layoutManager = GridLayoutManager(this, 3)
        adapterGaleri = GaleriAdapter(galeri, this)
        rvGaleri.adapter = adapterGaleri
        rvGaleri.layoutManager = layoutManager
        rvGaleri.setHasFixedSize(true)

    }

    override fun onItemClick(position: Int) {
//        Toast.makeText(this, "Pilih "+galeri[position].fotoGaleri, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, FullScreenGaleriActivity::class.java)
        intent.putExtra("Foto", galeri[position].fotoGaleri)
        startActivity(intent)
    }
}