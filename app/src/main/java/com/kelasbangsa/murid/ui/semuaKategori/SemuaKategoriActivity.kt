package com.kelasbangsa.murid.ui.semuaKategori

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.KategoriAdapter
import com.kelasbangsa.murid.data.model.Kategori
import com.kelasbangsa.murid.ui.kategori.KategoriAkademikActivity

class SemuaKategoriActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var rvKategori : RecyclerView

    var kategori : MutableList<Kategori> =  ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semua_kategori)

        //INIT VIEW
        rvKategori = findViewById(R.id.rv_semua_kategori)

        //List kategori
        kategori.add(Kategori(1, R.drawable.ic_kategori_akademik,"Akademik"))
        kategori.add(Kategori(2, R.drawable.ic_kategori_bahasa,"Bahasa"))
        kategori.add(Kategori(3, R.drawable.ic_kategori_agama,"Agama"))
        kategori.add(Kategori(4, R.drawable.ic_kategori_keterampilan,"Keterampilan"))
        kategori.add(Kategori(5, R.drawable.ic_kategori_teknologi,"Teknologi"))
        kategori.add(Kategori(6, R.drawable.ic_kategori_olahraga,"Olahraga"))
        kategori.add(Kategori(7, R.drawable.ic_kategori_musik,"Musik"))

        //set adapter kategori
        val layoutManagerKategori = GridLayoutManager(this,3)
        val adapterKategori = KategoriAdapter(kategori, this)
        rvKategori.layoutManager = layoutManagerKategori
        rvKategori.adapter = adapterKategori
        rvKategori.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Pilih "+kategori[position].namaKategori, Toast.LENGTH_SHORT).show()
        when(position){
            0-> {
                val akademik = Intent(this,KategoriAkademikActivity::class.java)
                startActivity(akademik)
            }

            1-> {
                val bahasa = Intent(this,KategoriAkademikActivity::class.java)
                startActivity(bahasa)
            }

            2-> {
                val agama = Intent(this,KategoriAkademikActivity::class.java)
                startActivity(agama)
            }

            3-> {
                val keterampilan = Intent(this,KategoriAkademikActivity::class.java)
                startActivity(keterampilan)
            }

            4-> {
                val teknologi = Intent(this,KategoriAkademikActivity::class.java)
                startActivity(teknologi)
            }

            5-> {
                val olahraga = Intent(this,KategoriAkademikActivity::class.java)
                startActivity(olahraga)
            }

            6-> {
                val musik = Intent(this,KategoriAkademikActivity::class.java)
                startActivity(musik)
            }

        }
    }
}