package com.kelasbangsa.murid.ui.semuaKategori

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.Kategori

class SemuaKategoriActivity : AppCompatActivity() {

    private lateinit var rvKategori : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semua_kategori)

        //INIT VIEW
        rvKategori = findViewById(R.id.rv_semua_kategori)

        //List kategori
        val kategori : MutableList<Kategori> =  ArrayList()
        kategori.add(Kategori(1, R.drawable.ic_kategori_akademik,"Akademik"))
        kategori.add(Kategori(2, R.drawable.ic_kategori_bahasa,"Bahasa"))
        kategori.add(Kategori(3, R.drawable.ic_kategori_agama,"Agama"))
        kategori.add(Kategori(4, R.drawable.ic_kategori_keterampilan,"Keterampilan"))
        kategori.add(Kategori(5, R.drawable.ic_kategori_teknologi,"Teknologi"))
        kategori.add(Kategori(6, R.drawable.ic_kategori_olahraga,"Olahraga"))
        kategori.add(Kategori(7, R.drawable.ic_kategori_musik,"Musik"))

        //set adapter kategori
//        val layoutManagerKategori = GridLayoutManager(this,3)
//        val adapterKategori = KategoriAdapter(kategori)
//        rvKategori.layoutManager = layoutManagerKategori
//        rvKategori.adapter = adapterKategori
//        rvKategori.setHasFixedSize(true)
    }
}